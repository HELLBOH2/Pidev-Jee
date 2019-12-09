package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;
	@Column(name = "nom")
	protected String nom;
	@Column(name = "prenom")
	protected String prenom;
	@Column(name = "email")
	protected String email;
	@Column(name= "password")
	protected String password;
	@OneToMany(mappedBy="user1")
	private List<Discussion> discussions1;
	@OneToMany(mappedBy="user2")
	private List<Discussion> discussions2;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		
	}
	
	
	public List<Discussion> getDiscussions1() {
		return discussions1;
	}
	public void setDiscussions1(List<Discussion> discussions1) {
		this.discussions1 = discussions1;
	}
	public List<Discussion> getDiscussions2() {
		return discussions2;
	}
	public void setDiscussions2(List<Discussion> discussions2) {
		this.discussions2 = discussions2;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password
				+ "]";
	}
	public User(String nom, String prenom, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	public User() {
		
	}
	
	
	}
