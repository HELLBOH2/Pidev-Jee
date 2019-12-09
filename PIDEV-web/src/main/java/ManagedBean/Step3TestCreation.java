package ManagedBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Services.EvaluationTestImpl;
import Services.UserService;
import model.AspNetUser;
import model.Criteria;
import model.Evaluationtest;
import model.Possiblerespons;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@ManagedBean (name = "step3")
@SessionScoped
public class Step3TestCreation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static AspNetUser managerLogger ;
	private static Evaluationtest testInCreation ;
	private static List<Possiblerespons> responses ;
	

	
	private String questionContent ; 
	private int Coeff ; 
	private int numberPossibleAnswers ;
	
	private static Criteria questionTocreate ;
	
	
	@EJB
	UserService collabService ; 
	@EJB 
	EvaluationTestImpl evaluationTestImpl;
	
	
	
	static {
		getLogger();
		getTestIncreation();
		
			 
	}
	

	
	public static void getTestIncreation() {
		testInCreation = new Evaluationtest();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 testInCreation = (Evaluationtest) sessionMap.get("testInCreation");
	}
	
	public static void getLogger() {
		managerLogger = new AspNetUser();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 managerLogger = (AspNetUser) sessionMap.get("logger");
	}
	

	
	
	
	
	
	
	
	//prepare the new question question
	public String Step3Action() {
		getLogger();

		getTestIncreation();
	
		
		questionTocreate = new Criteria();
		questionTocreate.setCr_Content(questionContent);
		questionTocreate.setCr_coefficient(Coeff);
		
		
		PrepareAnswersList();
		
		return "/pages/evaluationCreateStep3Answers.jsf?faces-redirect=true"; 
	}
	
	
	public void PrepareAnswersList() {
		responses = new ArrayList<>();
		for (int i=0 ; i<numberPossibleAnswers; i++) {
			Possiblerespons r = new Possiblerespons();
			r.setPr_Description("réponse" +Integer.toString(i));
			r.setCriteria(questionTocreate);
			responses.add(r);
		}
		System.out.println(responses.size());
	} 
	
	public String ConfirmAnswers() {
		for (Possiblerespons Response : responses) {
			System.out.println(Response.getCriteria().getCr_Content());
			System.out.println(Response.getPr_Description()+" "+Response.getPr_Content()+" ");
			questionTocreate.addPossibleResponse(Response);
			
		}
		testInCreation.addCriteria(questionTocreate);
		return "/pages/evaluationCreateStep3.jsf?faces-redirect=true" ; 
	}
	
	
	public String Confirm() {
		// 1)  persisting the test
				if(testInCreation!= null) 
				{
				testInCreation.setEtId(evaluationTestImpl.addEvaluationTest(testInCreation));
			
				//evaluationTestImpl.addCriteriaInformations(CI)
				}
				// 4) vider les variables de session 
				ReinitializeSession();
				
				return  "/pages/managerDashboard.jsf?faces-redirect=true";
		 
	}
	
	
	private void ReinitializeSession() {
		testInCreation = new Evaluationtest() ; 
		
	}
	
	
	


	
	
	
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public int getNumberPossibleAnswers() {
		return numberPossibleAnswers;
	}
	public void setNumberPossibleAnswers(int numberPossibleAnswers) {
		this.numberPossibleAnswers = numberPossibleAnswers;
	}

	public int getCoeff() {
		return Coeff;
	}

	public void setCoeff(int coeff) {
		Coeff = coeff;
	}

	public List<Possiblerespons> getResponses() {
		return responses;
	}

	public void setResponses(List<Possiblerespons> responses) {
		this.responses = responses;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
