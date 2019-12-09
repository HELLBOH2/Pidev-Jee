package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AspNetRoles database table.
 * 
 */
@Entity
@Table(name="AspNetRoles")
//@NamedQuery(name="AspNetRole.findAll", query="SELECT a FROM AspNetRole a")
public class AspNetRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to AspNetUserRole
	@OneToMany(mappedBy="aspNetRole")
	private List<AspNetUserRole> aspNetUserRoles;

	public AspNetRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AspNetUserRole> getAspNetUserRoles() {
		return this.aspNetUserRoles;
	}

	public void setAspNetUserRoles(List<AspNetUserRole> aspNetUserRoles) {
		this.aspNetUserRoles = aspNetUserRoles;
	}

	public AspNetUserRole addAspNetUserRole(AspNetUserRole aspNetUserRole) {
		getAspNetUserRoles().add(aspNetUserRole);
		aspNetUserRole.setAspNetRole(this);

		return aspNetUserRole;
	}

	public AspNetUserRole removeAspNetUserRole(AspNetUserRole aspNetUserRole) {
		getAspNetUserRoles().remove(aspNetUserRole);
		aspNetUserRole.setAspNetRole(null);

		return aspNetUserRole;
	}

}