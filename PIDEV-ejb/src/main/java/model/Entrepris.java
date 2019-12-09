package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Entreprises database table.
 * 
 */
@Entity
@Table(name="Entreprises")
//@NamedQuery(name="Entrepris.findAll", query="SELECT e FROM Entrepris e")
public class Entrepris implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EntrepriseId")
	private int entrepriseId;

	private String adresseEntreprise;

	private String logo;

	private String name;

	private int nbEmployee;

	private int numTel;

	private String slogon;

	public Entrepris() {
	}

	public int getEntrepriseId() {
		return this.entrepriseId;
	}

	public void setEntrepriseId(int entrepriseId) {
		this.entrepriseId = entrepriseId;
	}

	public String getAdresseEntreprise() {
		return this.adresseEntreprise;
	}

	public void setAdresseEntreprise(String adresseEntreprise) {
		this.adresseEntreprise = adresseEntreprise;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbEmployee() {
		return this.nbEmployee;
	}

	public void setNbEmployee(int nbEmployee) {
		this.nbEmployee = nbEmployee;
	}

	public int getNumTel() {
		return this.numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getSlogon() {
		return this.slogon;
	}

	public void setSlogon(String slogon) {
		this.slogon = slogon;
	}

}