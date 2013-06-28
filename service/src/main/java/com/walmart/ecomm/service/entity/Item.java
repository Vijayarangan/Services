
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
@Table(name = "item")

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	@Size(max = 45)
	@Column(name = "ITEM_NAME")
	private String itemName;
	@Size(max = 45)
	@Column(name = "ITEM_DESC")
	private String itemDesc;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ITEM_ID")
	private Integer itemId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
	private Collection<Inventory> inventoryCollection;

	public Item() {
	}

	public Item(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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
		hash += (itemId != null ? itemId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Item)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "com.walmart.ecomm.service.entity.Item[ itemId=" + itemId + " ]";
	}

}
