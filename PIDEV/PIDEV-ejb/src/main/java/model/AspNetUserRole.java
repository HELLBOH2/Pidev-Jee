package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AspNetUserRoles database table.
 * 
 */
@Entity
@Table(name="AspNetUserRoles")
//@NamedQuery(name="AspNetUserRole.findAll", query="SELECT a FROM AspNetUserRole a")
public class AspNetUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AspNetUserRolePK id;

	@Column(name="IdRole", insertable=false, updatable=false)
	private int idRole;

	//bi-directional many-to-one association to AspNetRole
	@ManyToOne
	@JoinColumn(name="RoleId", insertable=false, updatable=false)
	private AspNetRole aspNetRole;

	//bi-directional many-to-one association to AspNetUser
	@ManyToOne
	@JoinColumn(name="UserId", insertable=false, updatable=false)
	private AspNetUser aspNetUser;

	public AspNetUserRole() {
	}

	public AspNetUserRolePK getId() {
		return this.id;
	}

	public void setId(AspNetUserRolePK id) {
		this.id = id;
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public AspNetRole getAspNetRole() {
		return this.aspNetRole;
	}

	public void setAspNetRole(AspNetRole aspNetRole) {
		this.aspNetRole = aspNetRole;
	}

	public AspNetUser getAspNetUser() {
		return this.aspNetUser;
	}

	public void setAspNetUser(AspNetUser aspNetUser) {
		this.aspNetUser = aspNetUser;
	}

}