package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the AfterSaleServices database table.
 * 
 */
@Entity
@Table(name="AfterSaleServices")
@NamedQuery(name="AfterSaleService.findAll", query="SELECT a FROM AfterSaleService a")
public class AfterSaleService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Description")
	private String description;

	@Column(name="RequestDate")
	private Date requestDate;

	@Column(name="Response")
	private String response;

	@Column(name="Response_date")
	private Date response_date;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="ProjectManagerFK")
	private AspNetUser aspNetUser;
	
	@ManyToOne
	@JoinColumn(name="PackId")
	private Pack pack;

	public AfterSaleService() {
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getResponse_date() {
		return this.response_date;
	}

	public void setResponse_date(Date response_date) {
		this.response_date = response_date;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}
	
	public AfterSaleService(String description, Date requestDate, AspNetUser aspNetUser, Pack pack) {
		super();
		this.description = description;
		this.requestDate = requestDate;
		this.aspNetUser = aspNetUser;
		this.pack = pack;
	}

	public AfterSaleService(int id, Date requestDate,String description, String response, Date response_date,
			AspNetUser aspNetUser, Pack pack) {
		super();
		this.id = id;
		this.description = description;
		this.requestDate = requestDate;
		this.response = response;
		this.response_date = response_date;
		this.aspNetUser = aspNetUser;
		this.pack = pack;
	}
	
	

}