package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the evaluationtests database table.
 * 
 */
@Entity
@Table(name="evaluationtests")
//@NamedQuery(name="Evaluationtest.findAll", query="SELECT e FROM Evaluationtest e")
public class Evaluationtest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ET_ID")
	private int etId;

	private int creator_C_ID;

	@Column(name="creator_id")
	private int creatorId;

	@Column(name="Et_actualParticipantsNumber")
	private int et_actualParticipantsNumber;

	private float ET_actuelGlobalNote;

	private String ET_Description;

	@Column(name="Et_tType")
	private String et_tType;

	private String ET_Type;

	private float globaloNoteSoFar;

	private int testType_id;

	//bi-directional many-to-one association to Answertestaffectation
	@OneToMany(mappedBy="evaluationtest")
	private List<Answertestaffectation> answertestaffectations;

	//bi-directional many-to-one association to Criteria
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval =true, mappedBy="evaluationtest")
	private List<Criteria> criterias;

	//bi-directional many-to-one association to Evaluationguestaffectation
	@OneToMany(mappedBy="evaluationtest")
	private List<Evaluationguestaffectation> evaluationguestaffectations;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="ProjectManagerFK")
	private AspNetUser aspNetUser;

	public Evaluationtest() {
		this.criterias = new ArrayList<>();
	}

	public int getEtId() {
		return this.etId;
	}

	public void setEtId(int etId) {
		this.etId = etId;
	}

	public int getCreator_C_ID() {
		return this.creator_C_ID;
	}

	public void setCreator_C_ID(int creator_C_ID) {
		this.creator_C_ID = creator_C_ID;
	}

	public int getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public int getEt_actualParticipantsNumber() {
		return this.et_actualParticipantsNumber;
	}

	public void setEt_actualParticipantsNumber(int et_actualParticipantsNumber) {
		this.et_actualParticipantsNumber = et_actualParticipantsNumber;
	}

	public float getET_actuelGlobalNote() {
		return this.ET_actuelGlobalNote;
	}

	public void setET_actuelGlobalNote(float ET_actuelGlobalNote) {
		this.ET_actuelGlobalNote = ET_actuelGlobalNote;
	}

	public String getET_Description() {
		return this.ET_Description;
	}

	public void setET_Description(String ET_Description) {
		this.ET_Description = ET_Description;
	}

	public String getEt_tType() {
		return this.et_tType;
	}

	public void setEt_tType(String et_tType) {
		this.et_tType = et_tType;
	}

	public String getET_Type() {
		return this.ET_Type;
	}

	public void setET_Type(String ET_Type) {
		this.ET_Type = ET_Type;
	}

	public float getGlobaloNoteSoFar() {
		return this.globaloNoteSoFar;
	}

	public void setGlobaloNoteSoFar(float globaloNoteSoFar) {
		this.globaloNoteSoFar = globaloNoteSoFar;
	}

	public int getTestType_id() {
		return this.testType_id;
	}

	public void setTestType_id(int testType_id) {
		this.testType_id = testType_id;
	}

	public List<Answertestaffectation> getAnswertestaffectations() {
		return this.answertestaffectations;
	}

	public void setAnswertestaffectations(List<Answertestaffectation> answertestaffectations) {
		this.answertestaffectations = answertestaffectations;
	}

	public Answertestaffectation addAnswertestaffectation(Answertestaffectation answertestaffectation) {
		getAnswertestaffectations().add(answertestaffectation);
		answertestaffectation.setEvaluationtest(this);

		return answertestaffectation;
	}

	public Answertestaffectation removeAnswertestaffectation(Answertestaffectation answertestaffectation) {
		getAnswertestaffectations().remove(answertestaffectation);
		answertestaffectation.setEvaluationtest(null);

		return answertestaffectation;
	}

	public List<Criteria> getCriterias() {
		return this.criterias;
	}

	public void setCriterias(List<Criteria> criterias) {
		this.criterias = criterias;
	}

	public Criteria addCriteria(Criteria criteria) {
		getCriterias().add(criteria);
		criteria.setEvaluationtest(this);

		return criteria;
	}

	public Criteria removeCriteria(Criteria criteria) {
		getCriterias().remove(criteria);
		criteria.setEvaluationtest(null);

		return criteria;
	}

	public List<Evaluationguestaffectation> getEvaluationguestaffectations() {
		return this.evaluationguestaffectations;
	}

	public void setEvaluationguestaffectations(List<Evaluationguestaffectation> evaluationguestaffectations) {
		this.evaluationguestaffectations = evaluationguestaffectations;
	}

	public Evaluationguestaffectation addEvaluationguestaffectation(Evaluationguestaffectation evaluationguestaffectation) {
		getEvaluationguestaffectations().add(evaluationguestaffectation);
		evaluationguestaffectation.setEvaluationtest(this);

		return evaluationguestaffectation;
	}

	public Evaluationguestaffectation removeEvaluationguestaffectation(Evaluationguestaffectation evaluationguestaffectation) {
		getEvaluationguestaffectations().remove(evaluationguestaffectation);
		evaluationguestaffectation.setEvaluationtest(null);

		return evaluationguestaffectation;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}