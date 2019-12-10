package Interface;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.ejb.Local;

import model.Answerobject;
import model.Answertestaffectation;
import model.AspNetUser;
import model.CandidateOffer;
import model.Criteria;
import model.Evaluationguestaffectation;
import model.Evaluationtest;
import model.Possiblerespons;




@Local
public interface EvaluationTestServiceLocal {

	//CRUD EvaluationTest
	public int addEvaluationTest(Evaluationtest Et);
	public Evaluationtest GetEvaluationTest(int idEvaluationTest);
	public void EditEvaluationTest(Evaluationtest Et) ; 
	public void RemoveEvaluationTest(int EvaluationTestId);
	public List<Evaluationtest> getAllEvaluationTests();
	
	
	//public List<Evaluationtest> ShowEvaluationCandidate(AspNetUser collaborator);
	public List<Evaluationtest> ShowEvaluationCandidate(CandidateOffer collaborator);

	
	
	public void calculatePerformanceScoreperUser(int idcollaborator);
	
	public Evaluationguestaffectation GetGuestAffect (Evaluationtest evaluationTestId , CandidateOffer collaboratorId);
	
	
	//CRUD possibleResponses of the question 
	public int addCriteriaPossibleResponse(Possiblerespons CPR); 
	public void EditCriteriaPossibleResponse(Possiblerespons CPR); 
	public void RemoveCriteriaPossibleResponse(int ResponseId);
	public Possiblerespons GetPossibleResponse(int possibleResponseId);
	public List<Possiblerespons> getAllPossibleResponses();
	
	//CRUD Criteria (question) 
	public int addCriteriaInformations(Criteria CI) ; 
	public void EditCriteriaInforamtions(Criteria CI); 
	public void RemoveCriteriaInformations(int CriteriaInforamtionsId ); 
	public List<Criteria> getAllCriteriasCreated();
	public Criteria GetCriteria(int criteriaId);
	


	
	

	
	//affectation of the guest list of the evaluation test 
	public void AffectCollaboratorToGuestList(int evaluationTestId , int collaboratorId );
	public void RemoveCollaboratorfromGuestList(int evaluationTestId, int collaboratorId);
	//public Evaluationguestaffectation GetGuestAffect (int evaluationTestId , int collaboratorId);
	public void updateGuestAffectation (Evaluationguestaffectation guestAffect);
	

	
	
	public Evaluationtest RecalculateGlobalNote(float NewNotePerUser, int idEvaluationTest);

	//public CandidateOffer GetCandidateOffer(int idCandidate);
	public List<Evaluationtest> showquizparprojectmanager(int projmanagerId);
	
	//public AspNetUser GetCandidateOffer(AspNetUser idCandidate);
	public CandidateOffer GetCandidateOffer(AspNetUser idCandidate);
	 public CandidateOffer GetCandidateOffer2(int idCandidate);

}
