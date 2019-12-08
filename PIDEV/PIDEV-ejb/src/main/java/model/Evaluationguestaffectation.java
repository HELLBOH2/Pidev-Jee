package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the evaluationguestaffectations database table.
 * 
 */
@Entity
@Table(name="evaluationguestaffectations")
//@NamedQuery(name="Evaluationguestaffectation.findAll", query="SELECT e FROM Evaluationguestaffectation e")
public class Evaluationguestaffectation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int evaluationguestaffectationId;

	private int isAnswered;

	//bi-directional many-to-one association to CandidateOffer
	@ManyToOne
	@JoinColumn(name="idCollaborator")
	private CandidateOffer candidateOffer;

	//bi-directional many-to-one association to Evaluationtest
	@ManyToOne
	@JoinColumn(name="idEvaluationTest")
	private Evaluationtest evaluationtest;

	public Evaluationguestaffectation() {
	}

	public int getEvaluationguestaffectationId() {
		return this.evaluationguestaffectationId;
	}

	public void setEvaluationguestaffectationId(int evaluationguestaffectationId) {
		this.evaluationguestaffectationId = evaluationguestaffectationId;
	}

	public int getIsAnswered() {
		return this.isAnswered;
	}

	public void setIsAnswered(int isAnswered) {
		this.isAnswered = isAnswered;
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