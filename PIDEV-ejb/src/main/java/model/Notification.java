package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Notifications database table.
 * 
 */
@Entity
@Table(name="Notifications")
//@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NotificationId")
	private int notificationId;

	private String descNotification;

	//bi-directional many-to-one association to Appointment
	@ManyToOne
	@JoinColumn(name="AppointmentFK")
	private Appointment appointment;

	public Notification() {
	}

	public int getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getDescNotification() {
		return this.descNotification;
	}

	public void setDescNotification(String descNotification) {
		this.descNotification = descNotification;
	}

	public Appointment getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

}