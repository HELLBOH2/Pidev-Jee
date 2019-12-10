package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the Appointments database table.
 * 
 */
@Entity
@Table(name="Appointments")
//@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AppointmentId")
	private int appointmentId;

	private Date dateAppointment;

	private String messageAppointment;

	@Column(name="TimeAppointment")
	private String timeAppointment;

	private int typeAppointment;

	//bi-directional many-to-one association to CandidateOffer
	@ManyToOne
	@JoinColumn(name="CandidateOfferFK")
	private CandidateOffer candidateOffer;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="appointment")
	private List<Notification> notifications;

	public Appointment() {
	}

	public int getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getDateAppointment() {
		return this.dateAppointment;
	}

	public void setDateAppointment(Date dateAppointment) {
		this.dateAppointment = dateAppointment;
	}

	public String getMessageAppointment() {
		return this.messageAppointment;
	}

	public void setMessageAppointment(String messageAppointment) {
		this.messageAppointment = messageAppointment;
	}

	public String getTimeAppointment() {
		return this.timeAppointment;
	}

	public void setTimeAppointment(String timeAppointment) {
		this.timeAppointment = timeAppointment;
	}

	public int getTypeAppointment() {
		return this.typeAppointment;
	}

	public void setTypeAppointment(int typeAppointment) {
		this.typeAppointment = typeAppointment;
	}

	public CandidateOffer getCandidateOffer() {
		return this.candidateOffer;
	}

	public void setCandidateOffer(CandidateOffer candidateOffer) {
		this.candidateOffer = candidateOffer;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setAppointment(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setAppointment(null);

		return notification;
	}

}