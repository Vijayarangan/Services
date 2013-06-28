
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
@Table(name = "store")

public class Store implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STORE_ID")
    private Integer storeId;
    @Size(max = 45)
    @Column(name = "STORE_NAME")
    private String storeName;
    @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID")
    @ManyToOne(optional = false)
    private Region regionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private Collection<Inventory> inventoryCollection;

    public Store() {
    }

    public Store(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Region getRegionId() {
        return regionId;
    }

    public void setRegionId(Region regionId) {
        this.regionId = regionId;
    }

    @XmlTransient
    public Collection<Inventory> getInventoryCollection() {
        return inventoryCollection;
    }

    public void setInventoryCollection(Collection<Inventory> inventoryCollection) {
        this.inventoryCollection = inventoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
   
        if (!(object instanceof Store)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {
        return "com.walmart.ecomm.service.entity.Store[ storeId=" + storeId + " ]";
    }
    
}
