package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AspNetUserLogins database table.
 * 
 */
@Embeddable
public class AspNetUserLoginPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="LoginProvider")
	private String loginProvider;

	@Column(name="ProviderKey")
	private String providerKey;

	@Column(name="UserId", insertable=false, updatable=false)
	private int userId;

	public AspNetUserLoginPK() {
	}
	public String getLoginProvider() {
		return this.loginProvider;
	}
	public void setLoginProvider(String loginProvider) {
		this.loginProvider = loginProvider;
	}
	public String getProviderKey() {
		return this.providerKey;
	}
	public void setProviderKey(String providerKey) {
		this.providerKey = providerKey;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AspNetUserLoginPK)) {
			return false;
		}
		AspNetUserLoginPK castOther = (AspNetUserLoginPK)other;
		return 
			this.loginProvider.equals(castOther.loginProvider)
			&& this.providerKey.equals(castOther.providerKey)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.loginProvider.hashCode();
		hash = hash * prime + this.providerKey.hashCode();
		hash = hash * prime + this.userId;
		
		return hash;
	}
}