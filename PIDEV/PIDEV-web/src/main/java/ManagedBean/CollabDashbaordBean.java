package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.net.ssl.HttpsURLConnection;

import Services.EvaluationTestImpl;
import Services.TestAnswerImpl;
import Services.UserService;
import model.Answertestaffectation;
import model.AspNetUser;
import model.CandidateOffer;
import model.Evaluationtest;



@ManagedBean (name = "collabDash")
@SessionScoped
public class CollabDashbaordBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2345787763615000289L;
	
	
	
	private static List<Evaluationtest> AutoTestsToRender = new ArrayList<>();
	Evaluationtest testToAnswer = new Evaluationtest();
	
	//static connector collaborator 
	
	
	private static List<Evaluationtest> TestToRender ;
	
	private static AspNetUser managerLogger ; 
	
	@EJB
	EvaluationTestImpl evaluationService ;
	@EJB
	UserService userService ;
	@EJB
	TestAnswerImpl testanswerservice ; 
	
	

	
	static {
		getLogger();
	}
	
	private static void getLogger() {
		managerLogger = new AspNetUser();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 managerLogger = (AspNetUser) sessionMap.get("logger");
		
		
	}
	
	
	
	


	


	

	//show the tests that im invited to particpate to
	public String Show360EvaluationsToWhichInvited() {
		getLogger();
		TestToRender= new ArrayList<>();
		System.out.println("connecteur esttttttttttttttttt");
		System.out.println("connecteur esttttttttttttttttt"+managerLogger.getId());
		CandidateOffer c=evaluationService.GetCandidateOffer(userService.GetCandidateById(managerLogger.getId()));
		//CandidateOffer c = userService.GetCandidateById1(managerLogger.getId());
		List<Evaluationtest> list = evaluationService.ShowEvaluationCandidate(c);
		TestToRender = list ;
		return "/pages/collaborator/AllTests.jsf?faces-redirect=true";
	}
	
	
	
	public String AnswerEvaluationAction(Evaluationtest test) {
		System.out.println("this is the test"+ test.getEtId());
		saveTestToanswerInSession(test);
		createNewTestAnswersheet(test);
		
		return "/pages/collaborator/EvaluationAnswer.jsf?faces-redirect=true";
	}
	
	
	
	

	private void createNewTestAnswersheet(Evaluationtest test) {
		Answertestaffectation aff = new Answertestaffectation();
		aff.setEvaluationtest(test);
		
		System.out.println("-------------------------------------"+managerLogger.getId());
		CandidateOffer c = evaluationService.GetCandidateOffer(managerLogger);
		//AspNetUser a = userService.GetCandidateById(managerLogger.getId());
		//CandidateOffer c = 
		
		aff.setCandidateOffer(c);
		
	
				//testanswerservice.AddTestAnswerForParticipant(User.getId(), test.getId());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		  sessionMap.put("TestToAnswerSheet", aff);
		
	}







	private void saveTestToanswerInSession(Evaluationtest test) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		  sessionMap.put("TestToAnswer", test);
		
	}







	public List<Evaluationtest> getAutoTestsToRender() {
		return AutoTestsToRender;
	}


	public void setAutoTestsToRender(List<Evaluationtest> autoTestsToRender) {
		AutoTestsToRender = autoTestsToRender;
	}

	public Evaluationtest getTestToAnswer() {
		return testToAnswer;
	}

	public void setTestToAnswer(Evaluationtest testToAnswer) {
		this.testToAnswer = testToAnswer;
	}

	public  List<Evaluationtest> getTestToRender() {
		return TestToRender;
	}

	public  void setTestToRender(List<Evaluationtest> testToRender) {
		TestToRender = testToRender;
	}


	
	
	
	
	

}
