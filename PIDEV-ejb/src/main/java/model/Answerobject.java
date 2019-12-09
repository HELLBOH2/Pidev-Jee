package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the answerobjects database table.
 * 
 */
@Entity
@Table(name="answerobjects")
//@NamedQuery(name="Answerobject.findAll", query="SELECT a FROM Answerobject a")
public class Answerobject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="A_ObjectID")
	private int a_ObjectID;

	//bi-directional many-to-one association to Answertestaffectation
	@ManyToOne
	@JoinColumn(name="t_answertestaffectationFK")
	private Answertestaffectation answertestaffectation;

	//bi-directional many-to-one association to Criteria
	@ManyToOne
	@JoinColumn(name="idQuestion")
	private Criteria criteria;

	//bi-directional many-to-one association to Possiblerespons
	@ManyToOne
	@JoinColumn(name="idAnswer")
	private Possiblerespons possiblerespons;

	public Answerobject() {
		this.criteria = new Criteria();
		this.possiblerespons =new Possiblerespons();
		
	}

	public int getA_ObjectID() {
		return this.a_ObjectID;
	}

	public void setA_ObjectID(int a_ObjectID) {
		this.a_ObjectID = a_ObjectID;
	}

	public Answertestaffectation getAnswertestaffectation() {
		return this.answertestaffectation;
	}

	public void setAnswertestaffectation(Answertestaffectation answertestaffectation) {
		this.answertestaffectation = answertestaffectation;
	}

	public Criteria getCriteria() {
		return this.criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public Possiblerespons getPossiblerespons() {
		return this.possiblerespons;
	}

	public void setPossiblerespons(Possiblerespons possiblerespons) {
		this.possiblerespons = possiblerespons;
	}

}