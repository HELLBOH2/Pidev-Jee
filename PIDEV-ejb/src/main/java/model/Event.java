package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Events database table.
 * 
 */
@Entity
public class Event implements Serializable {
	public Event(int eventId, Date dateEvent, String description, String image, String name, int number_P) {
		super();
		this.eventId = eventId;
		this.dateEvent = dateEvent;
		this.description = description;
		this.image = image;
		this.name = name;
		this.number_P = number_P;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EventId")
	private int eventId;

	@Column(name="DateEvent")
	private Date dateEvent;

	@Column(name="Description")
	private String description;

	private String image;

	private String name;

	private int number_P;

	//bi-directional many-to-one association to AspNetUser
//	@ManyToOne
//	@JoinColumn(name="UserFK")
//	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
//	@ManyToOne
//	@JoinColumn(name="UserFK")
//	private AspNetUser aspNetUser2;

	public Event() {
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Date getDateEvent() {
		return this.dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber_P() {
		return this.number_P;
	}

	public void setNumber_P(int number_P) {
		this.number_P = number_P;
	}

//	public AspNetUser getAspNetUser1() {
//		return this.aspNetUser1;
//	}

//	public void setAspNetUser1(AspNetUser aspNetUser1) {
//		this.aspNetUser1 = aspNetUser1;
//	}

//	public AspNetUser getAspNetUser2() {
//		return this.aspNetUser2;
//	}

//	public void setAspNetUser2(AspNetUser aspNetUser2) {
//		this.aspNetUser2 = aspNetUser2;
//	}

}