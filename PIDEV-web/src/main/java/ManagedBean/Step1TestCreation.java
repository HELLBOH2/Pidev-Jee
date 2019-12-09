package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Services.EvaluationTestImpl;
import Services.UserService;
import model.AspNetUser;
import model.CandidateOffer;
import model.Evaluationtest;


@ManagedBean (name = "step1")
@SessionScoped
public class Step1TestCreation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private static AspNetUser managerLogger ;
	
	//here we have only the developper group , if we add another group we create for them new map and display it
	private  Map<CandidateOffer , String> DevelopperTargetMap ;
	
	
	

	private static String description;
	 
	private static Evaluationtest et ;
	private static Evaluationtest testInCreation ;
	
	
	
	@EJB
	UserService collabService ; 
	@EJB
	EvaluationTestImpl evaluationService ;
	
	static {
		getLogger();
		getTestIncreation();
		 
	}
	
	

	
	public static void getLogger() {
		managerLogger = new AspNetUser();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 managerLogger = (AspNetUser) sessionMap.get("logger");
	}

	public static void getTestIncreation() {
		testInCreation = new Evaluationtest();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 testInCreation = (Evaluationtest) sessionMap.get("testInCreation");
	}
	




	//prepare the test 
	public String Step1Action() {
		getLogger();
		getTestIncreation();
		
		testInCreation.setET_Description(description);
		
	
		//prepare for the next step the target map list
		//populateCandidateOfferNamesListMap();
		
		
		
		
		
		return "/pages/evaluationCreateStep3.jsf?faces-redirect=true";
	}
	
	public void populateCandidateOfferNamesListMap () {
		 DevelopperTargetMap = new HashMap<CandidateOffer, String>();
		List<CandidateOffer> targetList = new ArrayList<CandidateOffer>();
		
		targetList = collabService.GetAllCandidates();
		
		for (CandidateOffer c : targetList) {
			
			DevelopperTargetMap.put(c,  Integer.toString(c.getCandidateOfferId()));
		}
		
		SaveTargetList(DevelopperTargetMap);
		
		
	}
	
	
	private void SaveTargetList(Map<CandidateOffer, String> developperTargetMap) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		  sessionMap.put("targetListMap", developperTargetMap);
		
	}





	
	
	
	
	
	
	
	public String AbandonnCreation() {
		System.out.println("abandon creation");
		return null ;
	}


	





	
	
	
	
	
	
	








	

	public String getDescription() {
		return description;
	}
	

	public void setDescription(String description) {
		this.description = description;
	}







	public  Evaluationtest getEt() {
		return et;
	}



	public  void setEt(Evaluationtest et) {
		Step1TestCreation.et = et;
	}

	
	
	
	
	
	
	
	
}
