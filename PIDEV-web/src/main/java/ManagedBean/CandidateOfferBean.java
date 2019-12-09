package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Services.CandidateOfferService;
import Services.EvaluationTestImpl;
import Services.UserService;
import model.AspNetUser;
import model.CandidateOffer;
import model.Evaluationtest;

@ManagedBean(name = "CandidateOfferBean")
@SessionScoped
public class CandidateOfferBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int candidateOfferId;
	private String status;
	private int job_offerFK;
	private AspNetUser aspNetUser;
	
	
	
	
	private static int idChosen;
	

	
	
	
	
	
	@EJB
	CandidateOfferService candidateOfferService;
	@EJB
	EvaluationTestImpl evaluationService ;
	@EJB 
	UserService userService;
	
	private static List<CandidateOffer> listTorender ;
	private static List<Evaluationtest> listTorender2 ;
	private static AspNetUser managerLogger ; 
	private static CandidateOffer candidateOffer ;
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
	
	public String shoicetheQuiz(CandidateOffer l) {
		System.out.println(l.getAspNetUser().getId());
		idChosen = l.getAspNetUser().getId();
		listTorender2 = new ArrayList<Evaluationtest>();
		
		
		listTorender2 = evaluationService.showquizparprojectmanager(managerLogger.getId());
		if(listTorender.size() > 0) {
			return "/pages/MyListOfQuizCreated.jsf?faces-redirect=true" ; 
		}
		System.out.println("vous n'avez pas encore crée ce type de tests");
		
		return "/pages/managerDashboard.jsf?faces-redirect=true" ;
	}
	
	
	public String showAuto2() {
		listTorender = new ArrayList<CandidateOffer>();
		
		
		listTorender = candidateOfferService.GetAllCandidates();
		
		
		for(CandidateOffer c : listTorender) {
			System.out.println(c.getAspNetUser().getEmail()+"jjjjjjjjjjjjjjjj");
		}
		if(listTorender.size() > 0) {
			return "/pages/ListofCandidates.jsf?faces-redirect=true" ; 
		}
		System.out.println("NO ROWS ");
		
		return "/pages/managerDashboard.jsf?faces-redirect=true" ;
		
	}
	
	public String AffectQuiz(Evaluationtest evaluationtest)
	{
	
		
		evaluationService.AffectCollaboratorToGuestList(evaluationtest.getEtId(), idChosen);
		
		
		//idChosen = 0;
		
		return "/pages/ListofCandidates.jsf?faces-redirect=true";
	}
	
	
	public String Back()
	{
//listTorender = new ArrayList<CandidateOffer>();
//		
//		
//		listTorender = candidateOfferService.GetAllCandidates();
		return "/pages/ListofCandidates.jsf?faces-redirect=true" ;
	}
	
	
	
	
	
	
	
	
	
	
	public int getCandidateOfferId() {
		return candidateOfferId;
	}
	public void setCandidateOfferId(int candidateOfferId) {
		this.candidateOfferId = candidateOfferId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getJob_offerFK() {
		return job_offerFK;
	}
	public void setJob_offerFK(int job_offerFK) {
		this.job_offerFK = job_offerFK;
	}
	public AspNetUser getAspNetUser() {
		return aspNetUser;
	}
	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}
	
	
	public List<CandidateOffer> getListTorender() {
		return listTorender;
	}

	public void setListTorender(List<CandidateOffer> listTorender) {
		this.listTorender = listTorender;
	}

	public  List<Evaluationtest> getListTorender2() {
		return listTorender2;
	}

	public  void setListTorender2(List<Evaluationtest> listTorender2) {
		this.listTorender2 = listTorender2;
	}
	
	
	
	
}
