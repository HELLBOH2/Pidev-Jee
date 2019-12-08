package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CategorieJobOffres database table.
 * 
 */
@Entity
@Table(name="CategorieJobOffres")
//@NamedQuery(name="CategorieJobOffre.findAll", query="SELECT c FROM CategorieJobOffre c")
public class CategorieJobOffre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String categorie;

	//bi-directional many-to-one association to JobOffer
	@OneToMany(mappedBy="categorieJobOffre")
	private List<JobOffer> jobOffers;

	public CategorieJobOffre() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public List<JobOffer> getJobOffers() {
		return this.jobOffers;
	}

	public void setJobOffers(List<JobOffer> jobOffers) {
		this.jobOffers = jobOffers;
	}

	public JobOffer addJobOffer(JobOffer jobOffer) {
		getJobOffers().add(jobOffer);
		jobOffer.setCategorieJobOffre(this);

		return jobOffer;
	}

	public JobOffer removeJobOffer(JobOffer jobOffer) {
		getJobOffers().remove(jobOffer);
		jobOffer.setCategorieJobOffre(null);

		return jobOffer;
	}

}