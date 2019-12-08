package ManagedBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Services.EvaluationTestImpl;
import Services.TestAnswerImpl;
import Services.UserService;
import model.Answerobject;
import model.Answertestaffectation;
import model.AspNetUser;
import model.CandidateOffer;
import model.Criteria;
import model.Evaluationguestaffectation;
import model.Evaluationtest;
import model.Possiblerespons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@ManagedBean (name = "AnswerToConfirm")
@SessionScoped
public class AnswerToConfirmBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static AspNetUser logger ;
	private static Map<Criteria ,Possiblerespons> answerMap;
	private static Answertestaffectation answerAff ;
	
	 
	
	
	@EJB
	EvaluationTestImpl evaluationService ;
	@EJB
	UserService userService ;
	@EJB
	TestAnswerImpl testanswerservice ; 
	
	
	
	static {
		logger  = GetLogger();
		
		
	
	}
	

	
	
	
	public static AspNetUser GetLogger() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		  return (AspNetUser) sessionMap.get("logger");
	}




	private static void getAnswerAff() {
		answerAff = new Answertestaffectation();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		  answerAff =  (Answertestaffectation) sessionMap.get("TestToAnswerSheet");
		
	}




	private static void getAnswerMap() {
		answerMap = new HashMap<Criteria, Possiblerespons>();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 answerMap =  (Map<Criteria, Possiblerespons>) sessionMap.get("answerMap");
		
	}
	
	
	
	
	
	
	public String confirmAnswers() {
		getAnswerMap();
		getAnswerAff();
		
		if(answerMap.size()>0) {
			Answertestaffectation aff =testanswerservice.AddTestAnswerForParticipant(answerAff.getCandidateOffer().getCandidateOfferId(),answerAff.getEvaluationtest().getEtId());
			for (Entry<Criteria,Possiblerespons> rep: answerMap.entrySet()) {
				//instancier l'object de reponse
				Answerobject obj = new Answerobject(); 
				//System.out.println(obj.getCriteria());
				
				System.out.println(rep.getKey().getCr_ID()+"jjjjjjjjjjjjjjjjjjjjjjj");
				obj.getCriteria().setCr_ID(rep.getKey().getCr_ID());
				
				System.out.println(rep.getValue().getPr_ID()+"yyyyyyyyyyyyyyyyyyy");
				obj.getPossiblerespons().setPr_ID(rep.getValue().getPr_ID());
				
				obj.setAnswertestaffectation(aff);
				
				
				testanswerservice.AddAnswerObject(obj);
				
				//to change---------
			float sr = testanswerservice.CalculateNotePerParticipant(answerAff.getCandidateOffer().getCandidateOfferId(),answerAff.getEvaluationtest().getEtId());
			
			System.out.println("scoreeeeeeeeeeeeee mte3 *****"+sr);
				//add in here the calcul method CalculateNotePerParticipant
			}
		}
		updateGuestAff();
		Reinitialize();
		return "/pages/collaborator/CollaboratorDashboard.jsf?faces-redirect=true";
	}
	
	
	public void updateGuestAff(){
		Evaluationguestaffectation aff = new Evaluationguestaffectation();
		
		CandidateOffer collabId = answerAff.getCandidateOffer();
		Evaluationtest testId = answerAff.getEvaluationtest();
		
		aff = evaluationService.GetGuestAffect(testId, collabId);
		aff.setIsAnswered(1);;
		evaluationService.updateGuestAffectation(aff);
	}
	
	
	public void Reinitialize(){
		answerMap = new HashMap<>();
		answerAff = new Answertestaffectation();
	}
	
	
	public String  cancelAnswer() {
		Reinitialize();
		
		System.out.println(answerMap);
		return "/pages/collaborator/CollaboratorDashboard.jsf?faces-redirect=true";
	}
	
	
	
	public void testMapAnswer() {
		
	
		
		System.out.println("id collaborator"+answerAff.getCandidateOffer().getCandidateOfferId() +"id test"+answerAff.getEvaluationtest().getEtId());
	}





	
	
	
	
	
	
	
}
