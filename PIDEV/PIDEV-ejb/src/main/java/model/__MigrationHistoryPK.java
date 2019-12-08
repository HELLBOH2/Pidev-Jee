package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the __MigrationHistory database table.
 * 
 */
@Embeddable
public class __MigrationHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MigrationId")
	private String migrationId;

	@Column(name="ContextKey")
	private String contextKey;

	public __MigrationHistoryPK() {
	}
	public String getMigrationId() {
		return this.migrationId;
	}
	public void setMigrationId(String migrationId) {
		this.migrationId = migrationId;
	}
	public String getContextKey() {
		return this.contextKey;
	}
	public void setContextKey(String contextKey) {
		this.contextKey = contextKey;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof __MigrationHistoryPK)) {
			return false;
		}
		__MigrationHistoryPK castOther = (__MigrationHistoryPK)other;
		return 
			this.migrationId.equals(castOther.migrationId)
			&& this.contextKey.equals(castOther.contextKey);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.migrationId.hashCode();
		hash = hash * prime + this.contextKey.hashCode();
		
		return hash;
	}
}