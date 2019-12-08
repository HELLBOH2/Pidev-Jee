package ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.Index;

import Services.OfferService;
import Services.UserService;
import enumeration.OffreType;
import model.JobOffer;

@ManagedBean(name = "OffreBean")
@SessionScoped
public class OffreBean implements Serializable {
	
	
	private int jobOfferId;

	private String adresse;

	private String description;

	private Date endDateJobOffer;

	private String experience;

	private String namecategorie;

	private int nbplaces;

	private OffreType type_Offre;
	private String niveau;
	private Date startDateJobOffer;
	private String title;
	private String imageURL;




	@EJB
	OfferService offerService;
	
	public Set<JobOffer> getAlloffre() {
		return offerService.getAlloffre();	 
	}
	
	public void displayprojet(JobOffer offre) {
		this.setJobOfferId(offre.getJobOfferId());
		this.setAdresse(offre.getAdresse());
		this.setDescription(offre.getDescription());
		this.setEndDateJobOffer(offre.getEndDateJobOffer());
		this.setExperience(offre.getExperience());
		this.setAdresse(getNamecategorie());
		this.setNbplaces(offre.getNbplaces());
		OffreType ar[]=OffreType.values();
		this.setType_Offre(ar[offre.getType()]);
		this.setNiveau(offre.getNiveau());
		this.setStartDateJobOffer(offre.getStartDateJobOffer());
		this.setTitle(offre.getTitle());
		this.setImageURL(offre.getImageURL());
		
		
	}

	public int getJobOfferId() {
		return jobOfferId;
	}

	public void setJobOfferId(int jobOfferId) {
		this.jobOfferId = jobOfferId;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDateJobOffer() {
		return endDateJobOffer;
	}

	public void setEndDateJobOffer(Date endDateJobOffer) {
		this.endDateJobOffer = endDateJobOffer;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getNamecategorie() {
		return namecategorie;
	}

	public void setNamecategorie(String namecategorie) {
		this.namecategorie = namecategorie;
	}

	public int getNbplaces() {
		return nbplaces;
	}

	public void setNbplaces(int nbplaces) {
		this.nbplaces = nbplaces;
	}

	public OffreType getType_Offre() {
		return type_Offre;
	}

	public void setType_Offre(OffreType type_Offre) {
		this.type_Offre = type_Offre;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Date getStartDateJobOffer() {
		return startDateJobOffer;
	}

	public void setStartDateJobOffer(Date startDateJobOffer) {
		this.startDateJobOffer = startDateJobOffer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public OfferService getOfferService() {
		return offerService;
	}

	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

	
	

}
