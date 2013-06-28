
package com.walmart.ecomm.service.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vrangan
 */
@Entity
@Table(name = "geography")

public class Geography implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "LOCALE_ID")
	private Integer localeId;
	@Size(max = 45)
	@Column(name = "LOCALE_NAME")
	private String localeName;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "localeId")
	private Collection<Region> regionCollection;

	public Geography() {
	}

	public Geography(Integer localeId) {
		this.localeId = localeId;
	}

	public Integer getLocaleId() {
		return localeId;
	}

	public void setLocaleId(Integer localeId) {
		this.localeId = localeId;
	}

	public String getLocaleName() {
		return localeName;
	}

	public void setLocaleName(String localeName) {
		this.localeName = localeName;
	}

	@XmlTransient
	public Collection<Region> getRegionCollection() {
		return regionCollection;
	}

	public void setRegionCollection(Collection<Region> regionCollection) {
		this.regionCollection = regionCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (localeId != null ? localeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Geography)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "com.walmart.ecomm.service.entity.Geography[ localeId=" + localeId + " ]";
	}

}
