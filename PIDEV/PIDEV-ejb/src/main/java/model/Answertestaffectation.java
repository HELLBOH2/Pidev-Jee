package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the answertestaffectations database table.
 * 
 */
@Entity
@Table(name="answertestaffectations")
//@NamedQuery(name="Answertestaffectation.findAll", query="SELECT a FROM Answertestaffectation a")
public class Answertestaffectation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int answertestaffectationId;

	private int isAnswered;

	private float scoreCalculated;

	//bi-directional many-to-one association to Answerobject
	@OneToMany(mappedBy="answertestaffectation")
	private List<Answerobject> answerobjects;

	//bi-directional many-to-one association to CandidateOffer
	@ManyToOne
	@JoinColumn(name="idCollaborator")
	private CandidateOffer candidateOffer;

	//bi-directional many-to-one association to Evaluationtest
	@ManyToOne
	@JoinColumn(name="idEvaluationTest")
	private Evaluationtest evaluationtest;

	public Answertestaffectation() {
	}

	public int getAnswertestaffectationId() {
		return this.answertestaffectationId;
	}

	public void setAnswertestaffectationId(int answertestaffectationId) {
		this.answertestaffectationId = answertestaffectationId;
	}

	public int getIsAnswered() {
		return this.isAnswered;
	}

	public void setIsAnswered(int isAnswered) {
		this.isAnswered = isAnswered;
	}

	public float getScoreCalculated() {
		return this.scoreCalculated;
	}

	public void setScoreCalculated(float scoreCalculated) {
		this.scoreCalculated = scoreCalculated;
	}

	public List<Answerobject> getAnswerobjects() {
		return this.answerobjects;
	}

	public void setAnswerobjects(List<Answerobject> answerobjects) {
		this.answerobjects = answerobjects;
	}

	public Answerobject addAnswerobject(Answerobject answerobject) {
		getAnswerobjects().add(answerobject);
		answerobject.setAnswertestaffectation(this);

		return answerobject;
	}

	public Answerobject removeAnswerobject(Answerobject answerobject) {
		getAnswerobjects().remove(answerobject);
		answerobject.setAnswertestaffectation(null);

		return answerobject;
	}

	public CandidateOffer getCandidateOffer() {
		return this.candidateOffer;
	}

	public void setCandidateOffer(CandidateOffer candidateOffer) {
		this.candidateOffer = candidateOffer;
	}

	public Evaluationtest getEvaluationtest() {
		return this.evaluationtest;
	}

	public void setEvaluationtest(Evaluationtest evaluationtest) {
		this.evaluationtest = evaluationtest;
	}

}