package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the possibleresponses database table.
 * 
 */
@Entity
@Table(name="possibleresponses")
//@NamedQuery(name="Possiblerespons.findAll", query="SELECT p FROM Possiblerespons p")
public class Possiblerespons implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Pr_ID")
	private int pr_ID;

	private int isRight;

	@Column(name="Pr_Content")
	private String pr_Content;

	@Column(name="Pr_Description")
	private String pr_Description;

	@Column(name="Pr_score")
	private int pr_score;

	//bi-directional many-to-one association to Answerobject
	@OneToMany(mappedBy="possiblerespons")
	private List<Answerobject> answerobjects;

	//bi-directional many-to-one association to Criteria
	@ManyToOne
	private Criteria criteria;

	public Possiblerespons() {
	}

	public int getPr_ID() {
		return this.pr_ID;
	}

	public void setPr_ID(int pr_ID) {
		this.pr_ID = pr_ID;
	}

	public int getIsRight() {
		return this.isRight;
	}

	public void setIsRight(int isRight) {
		this.isRight = isRight;
	}

	public String getPr_Content() {
		return this.pr_Content;
	}

	public void setPr_Content(String pr_Content) {
		this.pr_Content = pr_Content;
	}

	public String getPr_Description() {
		return this.pr_Description;
	}

	public void setPr_Description(String pr_Description) {
		this.pr_Description = pr_Description;
	}

	public int getPr_score() {
		return this.pr_score;
	}

	public void setPr_score(int pr_score) {
		this.pr_score = pr_score;
	}

	public List<Answerobject> getAnswerobjects() {
		return this.answerobjects;
	}

	public void setAnswerobjects(List<Answerobject> answerobjects) {
		this.answerobjects = answerobjects;
	}

	public Answerobject addAnswerobject(Answerobject answerobject) {
		getAnswerobjects().add(answerobject);
		answerobject.setPossiblerespons(this);

		return answerobject;
	}

	public Answerobject removeAnswerobject(Answerobject answerobject) {
		getAnswerobjects().remove(answerobject);
		answerobject.setPossiblerespons(null);

		return answerobject;
	}

	public Criteria getCriteria() {
		return this.criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public String toString() {
		return pr_Content;
	}
	
	

}