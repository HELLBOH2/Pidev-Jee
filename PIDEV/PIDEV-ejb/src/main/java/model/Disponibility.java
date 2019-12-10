package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Disponibilities database table.
 * 
 */
@Entity
@Table(name="Disponibilities")
//@NamedQuery(name="Disponibility.findAll", query="SELECT d FROM Disponibility d")
public class Disponibility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DisponibilityId")
	private int disponibilityId;

	private Date dateisponibility;

	private int endHourisponibility;

	private int startHourdisponibility;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="CandidatFK")
	private AspNetUser aspNetUser;

	public Disponibility() {
	}

	public int getDisponibilityId() {
		return this.disponibilityId;
	}

	public void setDisponibilityId(int disponibilityId) {
		this.disponibilityId = disponibilityId;
	}

	public Date getDateisponibility() {
		return this.dateisponibility;
	}

	public void setDateisponibility(Timestamp dateisponibility) {
		this.dateisponibility = dateisponibility;
	}

	public int getEndHourisponibility() {
		return this.endHourisponibility;
	}

	public void setEndHourisponibility(int endHourisponibility) {
		this.endHourisponibility = endHourisponibility;
	}

	public int getStartHourdisponibility() {
		return this.startHourdisponibility;
	}

	public void setStartHourdisponibility(int startHourdisponibility) {
		this.startHourdisponibility = startHourdisponibility;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}