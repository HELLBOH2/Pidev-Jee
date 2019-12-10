
package Interface;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import model.Answerobject;
import model.Answertestaffectation;
import model.AspNetUser;
import model.CandidateOffer;
import model.Criteria;
import model.Evaluationtest;
import model.Possiblerespons;


@Remote
public interface EvaluationTestAnswerRemote {
	//ajouter l'affectation quand le collaborator veut participer au test
	public Answertestaffectation AddTestAnswerForParticipant(int idCollaborator , int idEvaluationTest); 
	public Answertestaffectation AddAnswer(Answertestaffectation a);

	public List<Evaluationtest> GetParticipationsOfCollaborator(int idCollaborator); 
	public List<AspNetUser> GetParticipantsToTest(int idEvaluationTest);
	//public Answertestaffectation GetTestAnswerById(int evaluationTestId , int collaboratorId);
	public List<Answertestaffectation> GetAlltestsByidTest(int idTest);
	public void editTestAnswer (Answertestaffectation testanswer);
	
	
	

	public Answertestaffectation GetTestAnswerById(CandidateOffer evaluationTestId , Evaluationtest collaboratorId);
	
	public void RecalculateGlobalNoteSoFarOFTheTest(int idEvaluationTest);
//	public Map<Collaborator, List<EvaluationTest>> GetTestAnswer360PerTarget(int idTest);
//	public Map<Collaborator,List<EvaluationTest>> GetTestAnswersAutoPerCollaborator(int idCollaborator);
	
	
	
	
	public  Answerobject AddAnswerObject(Answerobject o) ;
	public Answerobject RemoveAnswerObject(Answerobject o );
	public void EditEvaluationTest(Evaluationtest Et);
	public List<Answerobject> getAnswersPerCollaboratorToTest( int idCollaborator , int idTest);
	
	
	public Criteria GetCriteria(int criteriaId);
	public Possiblerespons GetPossibleResponse(int possibleResponseId);
	

	
	///caluculate the actual global note of the test
	public float CalculateNotePerParticipant(int answertestaffectationId);
	public Evaluationtest GetEvaluationTest(int idEvaluationTest);
	
	
	

}
