package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import Interface.EvaluationTestAnswerRemote;
import model.Answerobject;
import model.Answertestaffectation;
import model.AspNetUser;
import model.CandidateOffer;
import model.Criteria;
import model.Evaluationguestaffectation;
import model.Evaluationtest;
import model.Possiblerespons;
import Interface.EvaluationTestAnswerLocal;






@Stateless 
@LocalBean
public class TestAnswerImpl implements  EvaluationTestAnswerRemote,EvaluationTestAnswerLocal {

	@PersistenceContext(unitName = "DBMAP-ejb")
	EntityManager em;

	@EJB
	UserService userService;
	@EJB
	EvaluationTestImpl evaluationTestImpl;
	
	public CandidateOffer GetCandidateOfferById(int candidateoffer)
	{
		System.out.println(candidateoffer+"idddddddddddddddddd");
		
		return em.find(CandidateOffer.class, candidateoffer);
		
	}
	public Evaluationtest  GetEvalutionTestById(int Evaluationtest) {
		
		return em.find(Evaluationtest.class, Evaluationtest);
	}
	
	
	@Override
	public Answertestaffectation AddTestAnswerForParticipant(int idCollaborator, int idEvaluationTest) {
		
		System.out.println(idEvaluationTest+"idddddddddddddddddd");
		System.out.println(idCollaborator+"id loggerrrrrrrrrrrrrrrrrrrr");
		Answertestaffectation testAnswer = new Answertestaffectation(); 
		CandidateOffer c =new CandidateOffer();
		Evaluationtest t = new Evaluationtest();
		 //il faut ke doner 2
		 c=evaluationTestImpl.GetCandidateOffer2(idCollaborator);
		 System.out.println(c.getCandidateOfferId()+"idddddddddddddddddddddCandidate");
		t = evaluationTestImpl.GetEvaluationTest(idEvaluationTest);
		
		
		testAnswer.setCandidateOffer(c);
		testAnswer.setEvaluationtest(t);
		
		
		em.persist(testAnswer);
		
		
		return testAnswer;
	}
	
	@Override
	public Answertestaffectation AddAnswer(Answertestaffectation a) {
		em.persist(a);
		return a;
	}
	




	@Override
	public Answerobject AddAnswerObject(Answerobject o) {
		em.persist(o);
		return o;
	}

	@Override
	public Answerobject RemoveAnswerObject(Answerobject o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answerobject> getAnswersPerCollaboratorToTest(int idCollaborator, int idTest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Answertestaffectation GetTestAnswerById(CandidateOffer collaboratorId  , Evaluationtest evaluationTestId ) {
		Answertestaffectation testanswer = new Answertestaffectation();
		
		
		
		
		TypedQuery<Answertestaffectation> query = em.createQuery("SELECT a FROM Answertestaffectation a WHERE a.candidateOffer=:candidateoffer and a.evaluationtest=:quiz ", Answertestaffectation.class);
		query.setParameter("candidateoffer", collaboratorId); 
		query.setParameter("quiz", evaluationTestId); 
		testanswer = query.getSingleResult();
		
		
		
		
		
		
	
		// get the lazy associations
		testanswer.getCandidateOffer().getStatus();
		testanswer.getEvaluationtest().getET_Description();
		testanswer.getAnswerobjects().size();
		
		
		
		
		
		testanswer.getEvaluationtest().getCriterias().size();
		for (Criteria question : testanswer.getEvaluationtest().getCriterias()) {
			question.getPossibleresponses().size();
		}
		
		return testanswer;
	}
	
	@Override
	public void editTestAnswer(Answertestaffectation testanswer) {
		em.merge(testanswer);
	}
	
	@Override
	public Evaluationtest GetEvaluationTest(int idEvaluationTest) {
		Evaluationtest evaluation = em.find(Evaluationtest.class, idEvaluationTest);
		//initialize all assocations
		evaluation.getAnswertestaffectations().size();
		
		
		
		return evaluation;
	}

	



	@Override
	public List<Answertestaffectation> GetAlltestsByidTest(int idTest) {
		List<Answertestaffectation> list = new ArrayList();
		Query q = em.createNativeQuery("SELECT * FROM `answertestaffectations` WHERE answertestaffectations.idEvaluationTest=?");
		
		q.setParameter(1, idTest); 
		list = q.getResultList();
		
		return list;
	}

	
	
	@Override
	public void EditEvaluationTest(Evaluationtest Et) {
		
		em.merge(Et);
		

	}
	
	@Override
	public Criteria GetCriteria(int criteriaId) {
		Criteria cr = new Criteria();
		cr=  em.find(Criteria.class,criteriaId);
		
		cr.getPossibleresponses().size();
		return cr;
	}
	
	
	
	
	// it works whenever a participant answer a test 360/auto
	
	public float CalculateNotePerParticipant(int idCollaborator, int idTest ) {
		System.out.println("startttttttttttttttttt");
		//1) fetch the test answer of this pk
		Evaluationtest t = evaluationTestImpl.GetEvaluationTest(idTest);
		CandidateOffer c = userService.GetCandidateById1(idCollaborator);
		
		System.out.println("5555555555555555555555555555555555555555555555555555555");
		Answertestaffectation testAnswer = GetTestAnswerById(c, t);
		System.out.println("6666666666666666666666666666666666");
		Evaluationtest test = new Evaluationtest();
		
		
		
		Map<Criteria,Possiblerespons> mapAnswer =new HashMap();
		Criteria question  ;
		Possiblerespons response ;
		
		//2) create the map answer from the answer objects
		for (Answerobject answerObject : testAnswer.getAnswerobjects()) {
			question= GetCriteria(answerObject.getCriteria().getCr_ID());
		
			response = GetPossibleResponse(answerObject.getPossiblerespons().getPr_ID());
			mapAnswer.put(question, response);
		}
		
		//3) calculate the note of this participation
		float CaluculatedNote = 0;
		float Allnote = 0;
		int allCoeffiQuestions = 0;
		for (Entry<Criteria, Possiblerespons> entry : mapAnswer.entrySet()) 
		{
			allCoeffiQuestions = allCoeffiQuestions +entry.getKey().getCr_coefficient();
			Allnote = Allnote + entry.getKey().getCr_coefficient() * entry.getValue().getPr_score();
		}
		
		System.out.println(Allnote+"all notes ");
		System.out.println(allCoeffiQuestions + "all coeff");
		CaluculatedNote = Allnote /allCoeffiQuestions;
	
		
		System.out.println("the score caluclatd is " +CaluculatedNote);
		testAnswer.setScoreCalculated(CaluculatedNote);
		
		//4) update the note in test answer table
		editTestAnswer(testAnswer);
		
		
		if(CaluculatedNote>=10)
		{
			Evaluationtest quiz=evaluationTestImpl.GetEvaluationTest(idTest);
			CandidateOffer condidatdoquiz= userService.GetCandidateById1(idCollaborator);
			Evaluationguestaffectation eva=evaluationTestImpl.GetGuestAffect(quiz, condidatdoquiz);
			eva.setStausofQuiz("Validated");
			evaluationTestImpl.EditEvalutionGuestAffectation(eva);
		}
		else
		{
			Evaluationtest quiz=evaluationTestImpl.GetEvaluationTest(idTest);
			CandidateOffer condidatdoquiz= userService.GetCandidateById1(idCollaborator);
			Evaluationguestaffectation eva=evaluationTestImpl.GetGuestAffect(quiz, condidatdoquiz);
			eva.setStausofQuiz("Not Validated");
			evaluationTestImpl.EditEvalutionGuestAffectation(eva);
			
		}

		
		return CaluculatedNote;
	}

	
	
	
	
	
	
	
	//update the collaborator with the new score in the database
	public void updateCollaborator(AspNetUser c){
		em.merge(c);
	}
	
	
	
	
	
	
	
	
	
	@Override
	public Possiblerespons GetPossibleResponse(int possibleResponseId) {
		return em.find(Possiblerespons.class, possibleResponseId);
	}
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////
	@Override
	public List<Evaluationtest> GetParticipationsOfCollaborator(int idCollaborator) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<AspNetUser> GetParticipantsToTest(int idEvaluationTest) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void RecalculateGlobalNoteSoFarOFTheTest(int idEvaluationTest) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public float CalculateNotePerParticipant(int answertestaffectationId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	





}
