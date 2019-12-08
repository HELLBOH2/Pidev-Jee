package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the AspNetUsers database table.
 * 
 */
@Entity
@Table(name="AspNetUsers")
//@NamedQuery(name="AspNetUser.findAll", query="SELECT a FROM AspNetUser a")
public class AspNetUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="AccessFailedCount")
	private int accessFailedCount;

	@Column(name="Description")
	private String description;

	@Column(name="Discriminator")
	private String discriminator;

	@Column(name="Email")
	private String email;

	@Column(name="EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name="FirstName")
	private String firstName;

	@Column(name="ImageURL")
	private String imageURL;

	@Column(name="LastName")
	private String lastName;

	@Column(name="LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private Date lockoutEndDateUtc;

	@Column(name="PasswordHash")
	private String passwordHash;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	@Column(name="Role")
	private String role;

	@Column(name="SecurityStamp")
	private String securityStamp;

	@Column(name="TwoFactorEnabled")
	private boolean twoFactorEnabled;

	@Column(name="UserName")
	private String userName;

	//bi-directional many-to-one association to AspNetUserClaim
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserClaim> aspNetUserClaims;

	//bi-directional many-to-one association to AspNetUserLogin
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserLogin> aspNetUserLogins;

	//bi-directional many-to-one association to AspNetUserRole
	@OneToMany(mappedBy="aspNetUser")
	private List<AspNetUserRole> aspNetUserRoles;

	//bi-directional many-to-one association to CandidateOffer
	@OneToMany(mappedBy="aspNetUser")
	private List<CandidateOffer> candidateOffers;

	//bi-directional many-to-one association to Disponibility
	@OneToMany(mappedBy="aspNetUser")
	private List<Disponibility> disponibilities;

	//bi-directional many-to-one association to JobOffer
	@OneToMany(mappedBy="aspNetUser1")
	private List<JobOffer> jobOffers1;

	//bi-directional many-to-one association to JobOffer
	@OneToMany(mappedBy="aspNetUser2")
	private List<JobOffer> jobOffers2;

	//bi-directional many-to-one association to Publication
//	@OneToMany(mappedBy="aspNetUser")
//	private List<Publication> publications;

	//bi-directional many-to-one association to Evaluationtest
	@OneToMany(mappedBy="aspNetUser")
	private List<Evaluationtest> evaluationtests;

	public AspNetUser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getImageURL() {
		return this.imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Date getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Date lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<AspNetUserClaim> getAspNetUserClaims() {
		return this.aspNetUserClaims;
	}

	public void setAspNetUserClaims(List<AspNetUserClaim> aspNetUserClaims) {
		this.aspNetUserClaims = aspNetUserClaims;
	}

	public AspNetUserClaim addAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().add(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(this);

		return aspNetUserClaim;
	}

	public AspNetUserClaim removeAspNetUserClaim(AspNetUserClaim aspNetUserClaim) {
		getAspNetUserClaims().remove(aspNetUserClaim);
		aspNetUserClaim.setAspNetUser(null);

		return aspNetUserClaim;
	}

	public List<AspNetUserLogin> getAspNetUserLogins() {
		return this.aspNetUserLogins;
	}

	public void setAspNetUserLogins(List<AspNetUserLogin> aspNetUserLogins) {
		this.aspNetUserLogins = aspNetUserLogins;
	}

	public AspNetUserLogin addAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().add(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(this);

		return aspNetUserLogin;
	}

	public AspNetUserLogin removeAspNetUserLogin(AspNetUserLogin aspNetUserLogin) {
		getAspNetUserLogins().remove(aspNetUserLogin);
		aspNetUserLogin.setAspNetUser(null);

		return aspNetUserLogin;
	}

	public List<AspNetUserRole> getAspNetUserRoles() {
		return this.aspNetUserRoles;
	}

	public void setAspNetUserRoles(List<AspNetUserRole> aspNetUserRoles) {
		this.aspNetUserRoles = aspNetUserRoles;
	}

	public AspNetUserRole addAspNetUserRole(AspNetUserRole aspNetUserRole) {
		getAspNetUserRoles().add(aspNetUserRole);
		aspNetUserRole.setAspNetUser(this);

		return aspNetUserRole;
	}

	public AspNetUserRole removeAspNetUserRole(AspNetUserRole aspNetUserRole) {
		getAspNetUserRoles().remove(aspNetUserRole);
		aspNetUserRole.setAspNetUser(null);

		return aspNetUserRole;
	}

	public List<CandidateOffer> getCandidateOffers() {
		return this.candidateOffers;
	}

	public void setCandidateOffers(List<CandidateOffer> candidateOffers) {
		this.candidateOffers = candidateOffers;
	}

	public CandidateOffer addCandidateOffer(CandidateOffer candidateOffer) {
		getCandidateOffers().add(candidateOffer);
		candidateOffer.setAspNetUser(this);

		return candidateOffer;
	}

	public CandidateOffer removeCandidateOffer(CandidateOffer candidateOffer) {
		getCandidateOffers().remove(candidateOffer);
		candidateOffer.setAspNetUser(null);

		return candidateOffer;
	}

	public List<Disponibility> getDisponibilities() {
		return this.disponibilities;
	}

	public void setDisponibilities(List<Disponibility> disponibilities) {
		this.disponibilities = disponibilities;
	}

	public Disponibility addDisponibility(Disponibility disponibility) {
		getDisponibilities().add(disponibility);
		disponibility.setAspNetUser(this);

		return disponibility;
	}

	public Disponibility removeDisponibility(Disponibility disponibility) {
		getDisponibilities().remove(disponibility);
		disponibility.setAspNetUser(null);

		return disponibility;
	}

	public List<JobOffer> getJobOffers1() {
		return this.jobOffers1;
	}

	public void setJobOffers1(List<JobOffer> jobOffers1) {
		this.jobOffers1 = jobOffers1;
	}

	public JobOffer addJobOffers1(JobOffer jobOffers1) {
		getJobOffers1().add(jobOffers1);
		jobOffers1.setAspNetUser1(this);

		return jobOffers1;
	}

	public JobOffer removeJobOffers1(JobOffer jobOffers1) {
		getJobOffers1().remove(jobOffers1);
		jobOffers1.setAspNetUser1(null);

		return jobOffers1;
	}

	public List<JobOffer> getJobOffers2() {
		return this.jobOffers2;
	}

	public void setJobOffers2(List<JobOffer> jobOffers2) {
		this.jobOffers2 = jobOffers2;
	}

	public JobOffer addJobOffers2(JobOffer jobOffers2) {
		getJobOffers2().add(jobOffers2);
		jobOffers2.setAspNetUser2(this);

		return jobOffers2;
	}

	public JobOffer removeJobOffers2(JobOffer jobOffers2) {
		getJobOffers2().remove(jobOffers2);
		jobOffers2.setAspNetUser2(null);

		return jobOffers2;
	}

//	public List<Publication> getPublications() {
//		return this.publications;
//	}
//
//	public void setPublications(List<Publication> publications) {
//		this.publications = publications;
//	}
//
//	public Publication addPublication(Publication publication) {
//		getPublications().add(publication);
//		publication.setAspNetUser(this);
//
//		return publication;
//	}
//
//	public Publication removePublication(Publication publication) {
//		getPublications().remove(publication);
//		publication.setAspNetUser(null);
//
//		return publication;
//	}

	public List<Evaluationtest> getEvaluationtests() {
		return this.evaluationtests;
	}

	public void setEvaluationtests(List<Evaluationtest> evaluationtests) {
		this.evaluationtests = evaluationtests;
	}

	public Evaluationtest addEvaluationtest(Evaluationtest evaluationtest) {
		getEvaluationtests().add(evaluationtest);
		evaluationtest.setAspNetUser(this);

		return evaluationtest;
	}

	public Evaluationtest removeEvaluationtest(Evaluationtest evaluationtest) {
		getEvaluationtests().remove(evaluationtest);
		evaluationtest.setAspNetUser(null);

		return evaluationtest;
	}

}