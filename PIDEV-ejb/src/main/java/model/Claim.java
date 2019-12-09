package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Claims database table.
 * 
 */
@Entity
@Table(name="Claims")
@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Description")
	private String description;

	@Column(name="Issue")
	private String issue;

	@Column(name="Response")
	private String response;

	@Column(name="Response_date")
	private Date response_date;

	@Column(name="Status")
	private int status;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="CandidatFk")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="AdminFK")
	private AspNetUser aspNetUser2;

	//bi-directional many-to-one association to AspNetUser
	

	public Claim() {
	}

	public Claim( String desc,String issue2, String response2, int status2,Date d,int id2,AspNetUser aspuser2) {
		// TODO Auto-generated constructor stub
		this.issue=issue2;
		this.response=response2;
		this.status=status2;
		this.response_date=d;
		this.id=id2;
		this.description=desc;
		this.aspNetUser1=aspuser2;
	}
	public Claim(String issue2, String response2, int status2,Date d) {
		// TODO Auto-generated constructor stub
		this.issue=issue2;
		this.response=response2;
		this.status=status2;
		this.response_date=d;
		
	}
	

	public Claim(String description, String issue,  Date response_date, 
			AspNetUser aspNetUser1) {
		super();
		
		this.description = description;
		this.issue = issue;
		
		this.response_date = response_date;
		
		this.aspNetUser1 = aspNetUser1;
		
	}
	public Claim(String description, String issue, String response,int status, Date response_date, 
			AspNetUser aspNetUser1 ,AspNetUser aspNetUser2) {
		super();
		
		this.description = description;
		this.issue = issue;
		this.response = response;
		this.response_date = response_date;
		this.status = status;
		this.aspNetUser1 = aspNetUser1;
		this.aspNetUser2 = aspNetUser2;
		
	}
	public Claim(String description, String issue, String response,int status, Date response_date, int id,
			AspNetUser aspNetUser1 ,AspNetUser aspNetUser2) {
		super();
		this.id=id;
		this.description = description;
		this.issue = issue;
		this.response = response;
		this.response_date = response_date;
		this.status = status;
		this.aspNetUser1 = aspNetUser1;
		this.aspNetUser2 = aspNetUser2;
		
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

	public String getIssue() {
		return this.issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
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

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public AspNetUser getAspNetUser1() {
		return this.aspNetUser1;
	}

	public void setAspNetUser1(AspNetUser aspNetUser1) {
		this.aspNetUser1 = aspNetUser1;
	}

	public AspNetUser getAspNetUser2() {
		return this.aspNetUser2;
	}

	public void setAspNetUser2(AspNetUser aspNetUser2) {
		this.aspNetUser2 = aspNetUser2;
	}

	

}