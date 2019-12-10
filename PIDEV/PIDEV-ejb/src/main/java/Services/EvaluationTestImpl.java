package Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Interface.EvaluaitonTestServiceRemote;
import Interface.EvaluationTestServiceLocal;
import model.Answerobject;
import model.Answertestaffectation;
import model.AspNetUser;
import model.CandidateOffer;
import model.Criteria;
import model.Evaluationguestaffectation;
import model.Evaluationtest;
import model.Possiblerespons;









@Stateless 
@LocalBean
public class EvaluationTestImpl implements EvaluaitonTestServiceRemote, EvaluationTestServiceLocal {
	@PersistenceContext(unitName = "DBMAP-ejb")
	EntityManager em;

	@EJB
	UserService userService;
	
	

	
	@Override
	public int addEvaluationTest(Evaluationtest Et) {

		em.persist(Et);
		return Et.getEtId();
	}
	
	@Override
	public Evaluationtest GetEvaluationTest(int idEvaluationTest) {
		System.out.println(idEvaluationTest+"idddddddddddddddddddd");
		Evaluationtest evaluation = em.find(Evaluationtest.class, idEvaluationTest);
		evaluation.getCriterias().size();
		evaluation.getAnswertestaffectations().size();
		return evaluation;
	}

	@Override
	public void EditEvaluationTest(Evaluationtest Et) {
		em.merge(Et);
	}

	@Override
	public void RemoveEvaluationTest(int EvaluationTestId) {
		Evaluationtest test = new Evaluationtest();
		test = em.find(Evaluationtest.class, EvaluationTestId);
		em.remove(test);

	}

	@Override
	public List<Evaluationtest> getAllEvaluationTests() {
		 List<Evaluationtest> list1 = new ArrayList<>();
 		 list1 =  em.createQuery("select e from Evaluationtest e", Evaluationtest.class).getResultList(); 
 		 
 		 //get the lazy associations 
 		 for (Evaluationtest test : list1) {
			test.getCriterias().size();
			test.getEvaluationguestaffectations().size();
			test.getAnswertestaffectations().size();
			
			
			
			
			for (Criteria question : test.getCriterias()) {
				question.getPossibleresponses().size();
			}
		}
 		 
		 return list1; 
	}

	

	@Override
	public int addCriteriaPossibleResponse(Possiblerespons CPR) {
		em.persist(CPR);
		return 	CPR.getPr_ID();
	}

	@Override
	public void EditCriteriaPossibleResponse(Possiblerespons CPR) {
		em.merge(CPR);
	}

	@Override
	public void RemoveCriteriaPossibleResponse(int ResponseId) {
		Possiblerespons reponse = new Possiblerespons();
		reponse = em.find(Possiblerespons.class, ResponseId);
		em.remove(reponse);

	}
	



	
	@Override
	public List<Possiblerespons> getAllPossibleResponses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCriteriaInformations(Criteria CI) {
		em.persist(CI);
		
		return 	CI.getCr_ID();
	}

	@Override
	public void EditCriteriaInforamtions(Criteria CI) {
		em.merge(CI) ; 

	}

	@Override
	public void RemoveCriteriaInformations(int CriteriaInforamtionsId) {
		Criteria question = new Criteria();
		question = em.find(Criteria.class, CriteriaInforamtionsId ); 
		em.remove(question);

	}
	@Override
	public Criteria GetCriteria(int criteriaId) {
		Criteria cr = new Criteria();
		cr=  em.find(Criteria.class,criteriaId);
		
		cr.getPossibleresponses().size();
		return cr;
	}

	@Override
	public List<Criteria> getAllCriteriasCreated() {
		// TODO Auto-generated method stub
		return null;
	}



	public CandidateOffer GetCandidateOffer(AspNetUser idCandidate) {
		System.out.println("l'id de conecteurrrrrrrrrrrrrrrrrr"+idCandidate.getId());
		TypedQuery<CandidateOffer> query = em.createQuery("SELECT a FROM CandidateOffer a WHERE a.aspNetUser=:collaborator ", CandidateOffer.class);
		query.setParameter("collaborator", idCandidate); 
		CandidateOffer c = query.getSingleResult();
		
//		return c.getAspNetUser();
		return c;
		
	}
	
	
	
	@Override
	public List<Evaluationtest> ShowEvaluationCandidate(CandidateOffer collaborator) {
		
		
		TypedQuery<Evaluationguestaffectation> query = em.createQuery("SELECT a FROM Evaluationguestaffectation a WHERE a.candidateOffer=:collaborator ", Evaluationguestaffectation.class);
		query.setParameter("collaborator", collaborator); 
		
		
		List<Evaluationguestaffectation> listAffectations = new ArrayList<>();
		List<Evaluationtest> list360 = new ArrayList<>();
		try { 
			
			listAffectations = query.getResultList();
			
			Evaluationtest test0 ;
			
			for(Evaluationguestaffectation aff :listAffectations) {
				test0  =new Evaluationtest();
				test0 = em.find(Evaluationtest.class, aff.getEvaluationtest().getEtId());
				
				
				//get the questions and its reponses
				test0.getAnswertestaffectations().size();
				test0.getCriterias().size();
				for(Criteria quest :test0.getCriterias()) {
					quest.getPossibleresponses().size();
				}
				
				
					list360.add(test0);
				
			}
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e); 
			}
		
		 
		
		return list360;
	}

	
	


	@Override
	public void AffectCollaboratorToGuestList(int evaluationTestId, int collaboratorId) {

		Evaluationguestaffectation evalguestAffect = new Evaluationguestaffectation(); 
		Evaluationtest t = GetEvaluationTest(evaluationTestId);
		CandidateOffer c = GetCandidateOffer(userService.GetCandidateById(collaboratorId));
		
		
		
		
		evalguestAffect.setCandidateOffer(c);
		evalguestAffect.setEvaluationtest(t);
		
	
		
		evalguestAffect.setIsAnswered(0);
		evalguestAffect.setStausofQuiz("Pending");
		em.persist(evalguestAffect);
		

	}
	
	@Override
	public void EditEvalutionGuestAffectation(Evaluationguestaffectation evaluationtest) {
		
	//	evaluationtest.setStausofQuiz("Validated");
		em.merge(evaluationtest);
	}
	
	@Override
	public void RemoveCollaboratorfromGuestList(int evaluationTestId, int collaboratorId) {
		Evaluationguestaffectation evalguestAffect = new Evaluationguestaffectation(); 
		
		TypedQuery<Evaluationguestaffectation> query = em.createQuery("SELECT a FROM Evaluationguestaffectation a WHERE a.idCollaborator=:candidateoffer and a.idEvaluationTest=:quiz ", Evaluationguestaffectation.class);
		query.setParameter("candidateoffer", collaboratorId); 
		query.setParameter("quiz", evaluationTestId); 
		evalguestAffect = query.getSingleResult();
		
	
		em.remove(evalguestAffect);
		
	}

	@Override
	public Evaluationguestaffectation GetGuestAffect (Evaluationtest evaluationTestId , CandidateOffer collaboratorId) {
		Evaluationguestaffectation evalguestAffect = new Evaluationguestaffectation(); 
		TypedQuery<Evaluationguestaffectation> query = em.createQuery("SELECT a FROM Evaluationguestaffectation a WHERE a.candidateOffer=:candidateoffer and a.evaluationtest=:quiz ", Evaluationguestaffectation.class);
		query.setParameter("candidateoffer", collaboratorId); 
		query.setParameter("quiz", evaluationTestId); 
		evalguestAffect = query.getSingleResult();
		
		
		
		
		return evalguestAffect;
	}
	

	
	@Override
	public List<Evaluationtest> showquizparprojectmanager(int projmanagerId) {
		List<Evaluationtest> allList = new ArrayList();
		allList = getAllEvaluationTests();
		Stream<Evaluationtest> streamCreatedByMeList = allList.stream();
		
		
		
		allList = streamCreatedByMeList.filter(l -> l.getAspNetUser().getId() == projmanagerId )
				.collect(Collectors.toList()) ;
		
		
		/*for (EvaluationTest test : allList) {
			System.out.println(test.getId());
		}*/
		return allList;
		
	}
	
	
	@Override
	public Possiblerespons GetPossibleResponse(int possibleResponseId) {
		return em.find(Possiblerespons.class, possibleResponseId);
	}
	
	@Override
	public void updateGuestAffectation(Evaluationguestaffectation guestAffect) {
		em.merge(guestAffect);
		
	}

	
	
	
	//************************************************************************************
	


	@Override
	public void calculatePerformanceScoreperUser(int idcollaborator) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public Evaluationtest RecalculateGlobalNote(float NewNotePerUser, int idEvaluationTest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateOffer GetCandidateOffer2(int idCandidate) {
	return em.find(CandidateOffer.class, idCandidate);
	}


	

	
	
	
	
	









	





	


	





	

	
}
