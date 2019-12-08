package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import Services.*;
import model.Answerobject;
import model.Answertestaffectation;
import model.AspNetUser;
import model.Criteria;
import model.Evaluationtest;
import model.Possiblerespons;



@ManagedBean (name = "TestAnswer")
@SessionScoped
public class EvalAnswerBean implements Serializable  {
	
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
	
	
	
	
	private  String selectedAnswer ;
	private static AspNetUser logger ; 
	private static Evaluationtest testToAnswer ; 
	private static Criteria nextQuestion ; 
	private static List<Criteria> questionsList = new ArrayList<>();
	private static Map<Criteria, Possiblerespons> mapAnswer ; 
	
	private static Set<Possiblerespons> responses ;
	
	
	
	private static List<Possiblerespons> responsesListPerQuestion  = new ArrayList<>();
	//map of the response with its in string because selectitem needs string value
	private static Map<Possiblerespons, String> responsesListPerQuestionMap ;
	

	private static Map<Criteria, List<Possiblerespons>> questionWithResponsesMap ;
	
	
	private static int indexActualQuestion =0;
	
	
	
	
	//variable to force the static context to execute one time
	private static boolean init = true;
	

	
	private   String feedbackContent ; 
	private static  String feedbackTitle ; 
	 
	
	private String Technicalscore ;
	private String communicationScore ; 
	private String softScore ; 
	
	
	
	

	
	
	static {
		logger  = GetLogger();
		//GetTestToAnswer();
		//PrepareFirstRender();
	
	} 
	
	public  void PrepareFirstRender(){
		 //-----------------------------------------------------------------------
		 //----------------------------------------------------------------------
		 //1) prepare the first question  to show 
		
		 mapAnswer = new HashMap<>();
		 questionsList  = testToAnswer.getCriterias();
		 
		 
		
		nextQuestion = new Criteria();
		if(questionsList.size()!= 0) 
		{
			nextQuestion = questionsList.get(indexActualQuestion);
		
		//---------------------------------------------------------------------
		//2) prepare the list of the answers of the first question
		
		 responsesListPerQuestion = new ArrayList<>();
		 responsesListPerQuestionMap = new HashMap<>();
			
		for (Possiblerespons response : nextQuestion.getPossibleresponses() ) {
				responsesListPerQuestion.add(response);
				responsesListPerQuestionMap.put(response, Integer.toString(response.getPr_ID()));
				}
		
		//------------------------------------------------------------------------------
		
		//3) initialize the map of question responses with the first element	
		
			
			questionWithResponsesMap = new HashMap<>();
			questionWithResponsesMap.put(nextQuestion,responsesListPerQuestion ); 
			
		//-------------------------------------------
		
		
	}
	}
	
	
	public  String LanchTest(){
		GetTestToAnswer();
		PrepareFirstRender();
		return "/pages/collaborator/EvaluationAnswer.jsf?faces-redirect=true";
	}
	
	
	public static AspNetUser GetLogger() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		  return (AspNetUser) sessionMap.get("logger");
	}
	
	
	
	private static void GetTestToAnswer() {
		//get the instance of the test to answer 
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		 testToAnswer = (Evaluationtest) sessionMap.get("TestToAnswer");
		 System.out.println("evlAnswerbean :this  is the id of the test  "+testToAnswer.getEtId());
		
	}
	
	
	
	
	
	public boolean prepareNextQuestion(){
		boolean isFinished =false ; 
		if(indexActualQuestion < questionsList.size() ) 
			
		{
		nextQuestion = new Criteria();
		nextQuestion = questionsList.get(indexActualQuestion);
		
		 responsesListPerQuestion = new ArrayList<>();
		 responsesListPerQuestionMap = new HashMap<>();
			
		 	for (Possiblerespons response : nextQuestion.getPossibleresponses() ) 
		 	{
				responsesListPerQuestion.add(response);
				responsesListPerQuestionMap.put(response, Integer.toString(response.getPr_ID()));
			}
		 	
		 	isFinished = false;
		 	return isFinished;
		}
		
		else
		{
			System.out.println("you have reached the end of questions");
			isFinished= true ;
			return isFinished;
		}
	}

	 public String saveAnswer(){
		 boolean finished ;
		 // get the answer
		 Possiblerespons answer = new Possiblerespons() ;
		 
		//parcourir le tableau des possibles reponses pour trouver la reponse
		 
			for (Possiblerespons response : responsesListPerQuestion) {
				if(response.getPr_ID() == Integer.parseInt(selectedAnswer)) {
					System.out.println("voila la reponseeeeeeeeeeeeeeeeeeeeeeeee"+response.getPr_Content());
					answer = response;
					}
			}
		// answer = evaluationService.GetPossibleResponse(Integer.parseInt(selectedAnswer));
			
			
		 mapAnswer.put(nextQuestion, answer);
		 
		 indexActualQuestion++;
		
		finished = prepareNextQuestion();
		 if(!finished)
		 return "/pages/collaborator/EvaluationAnswer.jsf?faces-redirect=true";
		 else  {
			 saveMapAnswerInsession();
			 Reinitialize();
			 return "/pages/collaborator/AnswerToConfirm.jsf?faces-redirect=true";
		 }
	}
	
	 public void Reinitialize() {
		 	
		 nextQuestion = new Criteria();
		 questionsList = new ArrayList<>();
		 testToAnswer = new Evaluationtest();
		 responsesListPerQuestionMap = new HashMap<>();
		 responsesListPerQuestion  = new ArrayList<>();
		 indexActualQuestion = 0;
	 }
	 
 
	private void saveMapAnswerInsession() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		  sessionMap.put("answerMap", mapAnswer);
		
	}



	public String cancelAnswer() {
		Reinitialize();
		return "/pages/collaborator/All360Tests.xhtml?faces-redirect=true";
	}
	
	
	public void confirmAnswers(){
		System.out.println("this is the map of the answers "+mapAnswer.size());
		for (Entry<Criteria, Possiblerespons> ans : mapAnswer.entrySet() ) {
			System.out.println("the answer for the question"+ans.getKey()+"is"+ans.getValue());
		}
		//save answers 
		//first we create the useranswer affectation
		if(!mapAnswer.isEmpty()) {
			Answertestaffectation aff =testanswerservice.AddTestAnswerForParticipant(logger.getId(), testToAnswer.getEtId());
			for (Entry<Criteria,Possiblerespons> rep: mapAnswer.entrySet()) {
				//instancier l'object de reponse
				Answerobject obj = new Answerobject(); 
				
				
				obj.getCriteria().setCr_ID((rep.getKey().getCr_ID()));
				
				obj.getPossiblerespons().setPr_ID(rep.getKey().getCr_ID());
				
				
				
				obj.setAnswertestaffectation(aff);
				
				testanswerservice.AddAnswerObject(obj);
			}
		}
		
		//testToAnswer.setActualparticipantsNumber(testToAnswer.getActualparticipantsNumber()+1);
		
		
		
		//test service noteperuser
		//float notePerUser = testanswerservice.CalculateNotePerParticipant(mapAnswer, testToAnswer.getId(), logger.getId());
		//System.out.println("noteperuser"+notePerUser);
		//evaluationService.RecalculateGlobalNote(notePerUser, testToAnswer.getId());
		
		System.out.println("finiiiiiiiiiiiiiiiiiiish");
		
	}
	


	
	
	
	
	
	
	public void refreshVariables() {
		mapAnswer = new HashMap<>();
		responsesListPerQuestion  = new ArrayList<>();
	}
	
	
	
	
	
	
	

	
	
	
	
	public String showScores() {
		
		return null;
	}
	
	
	
	
	

	

	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  Evaluationtest getTestToAnswer() {
		return testToAnswer;
	}


	public  void setTestToAnswer(Evaluationtest testToAnswer) {
		EvalAnswerBean.testToAnswer = testToAnswer;
	}


	public  List<Possiblerespons> getResponsesListPerQuestion() {
		return responsesListPerQuestion;
	}


	public  void setResponsesListPerQuestion(List<Possiblerespons> responsesListPerQuestion) {
		EvalAnswerBean.responsesListPerQuestion = responsesListPerQuestion;
	}


	public  List<Criteria> getQuestionsList() {
		return questionsList;
	}


	public  void setQuestionsList(List<Criteria> questionsList) {
		questionsList = questionsList;
	}


	public  Set<Possiblerespons> getResponses() {
		return responses;
	}


	public  void setResponses(Set<Possiblerespons> responses) {
		EvalAnswerBean.responses = responses;
	}


	public  Map<Criteria, List<Possiblerespons>> getQuestionWithResponsesMap() {
		return questionWithResponsesMap;
	}


	public  void setQuestionWithResponsesMap(
			Map<Criteria, List<Possiblerespons>> questionWithResponsesMap) {
		EvalAnswerBean.questionWithResponsesMap = questionWithResponsesMap;
	}


	public  int getIndexActualQuestion() {
		return indexActualQuestion;
	}


	public  void setIndexActualQuestion(int indexActualQuestion) {
		EvalAnswerBean.indexActualQuestion = indexActualQuestion;
	}







	public  boolean isInit() {
		return init;
	}


	public  void setInit(boolean init) {
		EvalAnswerBean.init = init;
	}


	public String getSelectedAnswer() {
		return selectedAnswer;
	}


	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}


	public  Map<Possiblerespons, String> getResponsesListPerQuestionMap() {
		return responsesListPerQuestionMap;
	}


	public  void setResponsesListPerQuestionMap(
			Map<Possiblerespons, String> responsesListPerQuestionMap) {
		EvalAnswerBean.responsesListPerQuestionMap = responsesListPerQuestionMap;
	}

	
	


	public Map<Criteria, Possiblerespons> getMapAnswer() {
		return mapAnswer;
	}


	public void setMapAnswer(Map<Criteria, Possiblerespons> mapAnswer) {
		this.mapAnswer = mapAnswer;
	}


	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public String getFeedbackTitle() {
		return feedbackTitle;
	}

	public void setFeedbackTitle(String feedbackTitle) {
		this.feedbackTitle = feedbackTitle;
	}

	public String getTechnicalscore() {
		return Technicalscore;
	}

	public void setTechnicalscore(String technicalscore) {
		Technicalscore = technicalscore;
	}

	public String getCommunicationScore() {
		return communicationScore;
	}

	public void setCommunicationScore(String communicationScore) {
		this.communicationScore = communicationScore;
	}

	public String getSoftScore() {
		return softScore;
	}

	public void setSoftScore(String softScore) {
		this.softScore = softScore;
	}



	public  Criteria getNextQuestion() {
		return nextQuestion;
	}



	public  void setNextQuestion(Criteria nextQuestion) {
		nextQuestion = nextQuestion;
	}


	






	

	









	
	


	


	
	
	
	
	
	
	
}
