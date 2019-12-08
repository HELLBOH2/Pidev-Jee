package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the JobOffers database table.
 * 
 */
@Entity
@Table(name="JobOffers")
//@NamedQuery(name="JobOffer.findAll", query="SELECT j FROM JobOffer j")
public class JobOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="JobOfferId")
	private int jobOfferId;

	@Column(name="Adresse")
	private String adresse;

	@Column(name="Description")
	private String description;

	@Column(name="EndDateJobOffer")
	private Date endDateJobOffer;

	@Column(name="Experience")
	private String experience;

	@Column(name="ImageURL")
	private String imageURL;

	private String namecategorie;

	private int nbplaces;

	@Column(name="Niveau")
	private String niveau;

	@Column(name="StartDateJobOffer")
	private Date startDateJobOffer;

	@Column(name="Title")
	private String title;

	@Column(name="Type")
	private int type;

	//bi-directional many-to-one association to CandidateOffer
	@OneToMany(mappedBy="jobOffer")
	private List<CandidateOffer> candidateOffers;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="ProjectManagerFK")
	private AspNetUser aspNetUser1;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="HRManager_Id")
	private AspNetUser aspNetUser2;

	//bi-directional many-to-one association to CategorieJobOffre
	@ManyToOne
	@JoinColumn(name="Categorie_id")
	private CategorieJobOffre categorieJobOffre;

	public JobOffer() {
	}

	public int getJobOfferId() {
		return this.jobOfferId;
	}

	public void setJobOfferId(int jobOfferId) {
		this.jobOfferId = jobOfferId;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDateJobOffer() {
		return this.endDateJobOffer;
	}

	public void setEndDateJobOffer(Date endDateJobOffer) {
		this.endDateJobOffer = endDateJobOffer;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getImageURL() {
		return this.imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getNamecategorie() {
		return this.namecategorie;
	}

	public void setNamecategorie(String namecategorie) {
		this.namecategorie = namecategorie;
	}

	public int getNbplaces() {
		return this.nbplaces;
	}

	public void setNbplaces(int nbplaces) {
		this.nbplaces = nbplaces;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Date getStartDateJobOffer() {
		return this.startDateJobOffer;
	}

	public void setStartDateJobOffer(Date startDateJobOffer) {
		this.startDateJobOffer = startDateJobOffer;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<CandidateOffer> getCandidateOffers() {
		return this.candidateOffers;
	}

	public void setCandidateOffers(List<CandidateOffer> candidateOffers) {
		this.candidateOffers = candidateOffers;
	}

	public CandidateOffer addCandidateOffer(CandidateOffer candidateOffer) {
		getCandidateOffers().add(candidateOffer);
		candidateOffer.setJobOffer(this);

		return candidateOffer;
	}

	public CandidateOffer removeCandidateOffer(CandidateOffer candidateOffer) {
		getCandidateOffers().remove(candidateOffer);
		candidateOffer.setJobOffer(null);

		return candidateOffer;
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

	public CategorieJobOffre getCategorieJobOffre() {
		return this.categorieJobOffre;
	}

	public void setCategorieJobOffre(CategorieJobOffre categorieJobOffre) {
		this.categorieJobOffre = categorieJobOffre;
	}

}