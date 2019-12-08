package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CandidateOffers database table.
 * 
 */
@Entity
@Table(name="CandidateOffers")
//@NamedQuery(name="CandidateOffer.findAll", query="SELECT c FROM CandidateOffer c")
public class CandidateOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CandidateOfferId")
	private int candidateOfferId;

	@Column(name="Status")
	private String status;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="candidateOffer")
	private List<Appointment> appointments;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="CandidatFK")
	private AspNetUser aspNetUser;

	//bi-directional many-to-one association to JobOffer
	@ManyToOne
	@JoinColumn(name="Job_offerFK")
	private JobOffer jobOffer;

	//bi-directional many-to-one association to Answertestaffectation
	@OneToMany(mappedBy="candidateOffer")
	private List<Answertestaffectation> answertestaffectations;

	//bi-directional many-to-one association to Evaluationguestaffectation
	@OneToMany(mappedBy="candidateOffer")
	private List<Evaluationguestaffectation> evaluationguestaffectations;

	public CandidateOffer() {
	}

	public int getCandidateOfferId() {
		return this.candidateOfferId;
	}

	public void setCandidateOfferId(int candidateOfferId) {
		this.candidateOfferId = candidateOfferId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setCandidateOffer(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setCandidateOffer(null);

		return appointment;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

	public JobOffer getJobOffer() {
		return this.jobOffer;
	}

	public void setJobOffer(JobOffer jobOffer) {
		this.jobOffer = jobOffer;
	}

	public List<Answertestaffectation> getAnswertestaffectations() {
		return this.answertestaffectations;
	}

	public void setAnswertestaffectations(List<Answertestaffectation> answertestaffectations) {
		this.answertestaffectations = answertestaffectations;
	}

	public Answertestaffectation addAnswertestaffectation(Answertestaffectation answertestaffectation) {
		getAnswertestaffectations().add(answertestaffectation);
		answertestaffectation.setCandidateOffer(this);

		return answertestaffectation;
	}

	public Answertestaffectation removeAnswertestaffectation(Answertestaffectation answertestaffectation) {
		getAnswertestaffectations().remove(answertestaffectation);
		answertestaffectation.setCandidateOffer(null);

		return answertestaffectation;
	}

	public List<Evaluationguestaffectation> getEvaluationguestaffectations() {
		return this.evaluationguestaffectations;
	}

	public void setEvaluationguestaffectations(List<Evaluationguestaffectation> evaluationguestaffectations) {
		this.evaluationguestaffectations = evaluationguestaffectations;
	}

	public Evaluationguestaffectation addEvaluationguestaffectation(Evaluationguestaffectation evaluationguestaffectation) {
		getEvaluationguestaffectations().add(evaluationguestaffectation);
		evaluationguestaffectation.setCandidateOffer(this);

		return evaluationguestaffectation;
	}

	public Evaluationguestaffectation removeEvaluationguestaffectation(Evaluationguestaffectation evaluationguestaffectation) {
		getEvaluationguestaffectations().remove(evaluationguestaffectation);
		evaluationguestaffectation.setCandidateOffer(null);

		return evaluationguestaffectation;
	}

}