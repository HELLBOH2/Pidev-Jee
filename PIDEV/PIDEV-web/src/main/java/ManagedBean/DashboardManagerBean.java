package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Services.EvaluationTestImpl;
import Services.TestAnswerImpl;
import Services.UserService;
import model.AspNetUser;
import model.Evaluationguestaffectation;
import model.Evaluationtest;



@ManagedBean(name = "managerBean")
@SessionScoped
public class DashboardManagerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	EvaluationTestImpl evaluationService ;
	@EJB
	UserService userService ;
	@EJB
	TestAnswerImpl testanswerservice ; 
	
	private static Evaluationtest testInCreation ;
	
	private static List<Evaluationguestaffectation> GuestAffList ; 
	

	
	
	
	
	private static AspNetUser managerLogger ; 
	
	private static  List<Evaluationtest> allTestsCreatedByManager ;
	
	private static List<Evaluationtest> listTorender ;
	
	private static int numberAnswers;
	private static int numberTargetList;
	
	
	
	
	//////// attributs pour edit 
	private String description;
	
	private static Evaluationtest testToUpdate;
	
	static
	{
		getLogger();
		
	}
	private static void getLogger() {
		managerLogger = new AspNetUser();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 managerLogger = (AspNetUser) sessionMap.get("logger");
		
		
	}
	
	public static void getTestIncreation() {
		testInCreation = new Evaluationtest();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 testInCreation = (Evaluationtest) sessionMap.get("testIncreation");
	}
	
	private static void getGuestAffList() {
		GuestAffList = new ArrayList<>();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 GuestAffList = (List<Evaluationguestaffectation>) sessionMap.get("TaregetAffList");
		
	}
	


	
	
	//creation d'un nouveau test
	public String create() {
		//prepare the list of possible testtypes (technique, ....)
		

		Evaluationtest t = new Evaluationtest();
		t.setAspNetUser(managerLogger);
	
	
		SaveTestInSession(t);
		
		return "/pages/evaluationCreateStep1.jsf?faces-redirect=true"; 
		
	}
	
	public void SaveTestInSession(Evaluationtest t){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		sessionMap.put("testInCreation" , t);
		 
	}
	
	
	
	
	

//Get
	public String EditQuiz(Evaluationtest t) {
		System.out.println(t.getEtId()+"kkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		testToUpdate = t;
		
		return "/pages/quizedit.jsf?faces-redirect=true";
	}
	
	public String DeleteQuiz(Evaluationtest t) {
		evaluationService.RemoveEvaluationTest(t.getEtId());
		listTorender= evaluationService.showquizparprojectmanager(managerLogger.getId());
		return "/pages/AutoTestsCreated.jsf?faces-redirect=true";
	}
	
	
	
	//Post
	public String saveEditchanges() {
		testToUpdate.setET_Description(description);
		evaluationService.EditEvaluationTest(testToUpdate);
		return "/pages/AutoTestsCreated.jsf?faces-redirect=true";
	}
	
	
	public String showAuto() {
		listTorender = new ArrayList<Evaluationtest>();
		
		
		listTorender = evaluationService.showquizparprojectmanager(managerLogger.getId());
		if(listTorender.size() > 0) {
			return "/pages/AutoTestsCreated.jsf?faces-redirect=true" ; 
		}
		System.out.println("vous n'avez pas encore crée ce type de tests");
		
		return "/pages/managerDashboard.jsf?faces-redirect=true" ;
	}
	




	
	
	
	
	
	
	
	
	public List<Evaluationtest> getListTorender() {
		return listTorender;
	}

	public void setListTorender(List<Evaluationtest> listTorender) {
		this.listTorender = listTorender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Evaluationtest getTestToUpdate() {
		return testToUpdate;
	}

	public void setTestToUpdate(Evaluationtest testToUpdate) {
		this.testToUpdate = testToUpdate;
	}
	
	
	
	
	
	
	

}
