
package com.walmart.ecomm.service.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "region")
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REGION_ID")
    private Integer regionId;
    @Size(max = 45)
    @Column(name = "REGION_NAME")
    private String regionName;
    @JoinColumn(name = "LOCALE_ID", referencedColumnName = "LOCALE_ID")
    @ManyToOne(optional = false)
    private Geography localeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId")
    private Collection<Store> storeCollection;

    public Region() {
    }

    public Region(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Geography getLocaleId() {
        return localeId;
    }

    public void setLocaleId(Geography localeId) {
        this.localeId = localeId;
    }

    @XmlTransient
    public Collection<Store> getStoreCollection() {
        return storeCollection;
    }

    public void setStoreCollection(Collection<Store> storeCollection) {
        this.storeCollection = storeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionId != null ? regionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
                if (!(object instanceof Region)) {
            return false;
        }
      
        return true;
    }

    @Override
    public String toString() {
        return "com.walmart.ecomm.service.entity.Region[ regionId=" + regionId + " ]";
    }
    
}
