package com.retailx.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public abstract  class BaseObject implements Serializable, PersistableObject{
	
	@Column(name = "CREATION_DATE", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date creationDate;
	
	@Column(name = "MODIFICATION_DATE", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	public Date modificationDate;

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

}
