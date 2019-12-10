package model;

import java.io.Serializable;
import javax.persistence.*;



import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the criteria database table.
 * 
 */
@Entity
@Table(name="criteria")
//@NamedQuery(name="Criteria.findAll", query="SELECT c FROM Criteria c")
public class Criteria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Cr_ID")
	private int cr_ID;

	@Column(name="Cr_coefficient")
	private int cr_coefficient;

	@Column(name="Cr_Content")
	private String cr_Content;

	@Column(name="Cr_Description")
	private String cr_Description;

	//bi-directional many-to-one association to Answerobject
	@OneToMany(mappedBy="criteria")
	private List<Answerobject> answerobjects;

	//bi-directional many-to-one association to Evaluationtest
	@ManyToOne
	@JoinColumn(name="evaluationTest_ET_ID")
	private Evaluationtest evaluationtest;

	//bi-directional many-to-one association to Possiblerespons
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval =true,mappedBy="criteria")
	private List<Possiblerespons> possibleresponses = new ArrayList<Possiblerespons>();

	public Criteria() {
		this.possibleresponses = new ArrayList<Possiblerespons>();
	}

	public int getCr_ID() {
		return this.cr_ID;
	}

	public void setCr_ID(int cr_ID) {
		this.cr_ID = cr_ID;
	}

	public int getCr_coefficient() {
		return this.cr_coefficient;
	}

	public void setCr_coefficient(int cr_coefficient) {
		this.cr_coefficient = cr_coefficient;
	}

	public String getCr_Content() {
		return this.cr_Content;
	}

	public void setCr_Content(String cr_Content) {
		this.cr_Content = cr_Content;
	}

	public String getCr_Description() {
		return this.cr_Description;
	}

	public void setCr_Description(String cr_Description) {
		this.cr_Description = cr_Description;
	}

	public List<Answerobject> getAnswerobjects() {
		return this.answerobjects;
	}

	public void setAnswerobjects(List<Answerobject> answerobjects) {
		this.answerobjects = answerobjects;
	}

	public Answerobject addAnswerobject(Answerobject answerobject) {
		getAnswerobjects().add(answerobject);
		answerobject.setCriteria(this);

		return answerobject;
	}

	public Answerobject removeAnswerobject(Answerobject answerobject) {
		getAnswerobjects().remove(answerobject);
		answerobject.setCriteria(null);

		return answerobject;
	}

	public Evaluationtest getEvaluationtest() {
		return this.evaluationtest;
	}

	public void setEvaluationtest(Evaluationtest evaluationtest) {
		this.evaluationtest = evaluationtest;
	}

	public List<Possiblerespons> getPossibleresponses() {
		return this.possibleresponses;
	}

	public void setPossibleresponses(List<Possiblerespons> possibleresponses) {
		this.possibleresponses = possibleresponses;
	}

//	public Possiblerespons addPossiblerespons(Possiblerespons possiblerespons) {
//	//	getPossibleresponses().add(possiblerespons);
//		possiblerespons.setCriteria(this);
//
//		return possiblerespons;
//	}
	public void addPossibleResponse(Possiblerespons reponse) {
		System.out.println(reponse+"jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
		reponse.setCriteria(this);
		
		this.possibleresponses.add(reponse);
	}
	
	
	//***********************************************************************

	public Possiblerespons removePossiblerespons(Possiblerespons possiblerespons) {
		getPossibleresponses().remove(possiblerespons);
		possiblerespons.setCriteria(null);

		return possiblerespons;
	}

}