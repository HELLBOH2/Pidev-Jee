package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AspNetUserClaims database table.
 * 
 */
@Entity
@Table(name="AspNetUserClaims")
//@NamedQuery(name="AspNetUserClaim.findAll", query="SELECT a FROM AspNetUserClaim a")
public class AspNetUserClaim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="ClaimType")
	private String claimType;

	@Column(name="ClaimValue")
	private String claimValue;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="UserId", insertable=false, updatable=false)
	private AspNetUser aspNetUser;

	public AspNetUserClaim() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimType() {
		return this.claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getClaimValue() {
		return this.claimValue;
	}

	public void setClaimValue(String claimValue) {
		this.claimValue = claimValue;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}