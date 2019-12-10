package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AspNetUserRoles database table.
 * 
 */
@Embeddable
public class AspNetUserRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="UserId", insertable=false, updatable=false)
	private int userId;

	@Column(name="RoleId", insertable=false, updatable=false)
	private int roleId;

	public AspNetUserRolePK() {
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return this.roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AspNetUserRolePK)) {
			return false;
		}
		AspNetUserRolePK castOther = (AspNetUserRolePK)other;
		return 
			(this.userId == castOther.userId)
			&& (this.roleId == castOther.roleId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.roleId;
		
		return hash;
	}
}