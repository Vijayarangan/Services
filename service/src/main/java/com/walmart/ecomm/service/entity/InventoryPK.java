
package com.walmart.ecomm.service.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vrangan
 */
@Embeddable
public class InventoryPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@NotNull
	@Column(name = "STORE_ID")
	private int storeId;
	@Basic(optional = false)
	@NotNull
	@Column(name = "ITEM_ID")
	private int itemId;

	public InventoryPK() {
	}

	public InventoryPK(int storeId, int itemId) {
		this.storeId = storeId;
		this.itemId = itemId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) storeId;
		hash += (int) itemId;
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof InventoryPK)) {
			return false;
		}
		InventoryPK other = (InventoryPK) object;
		if (this.storeId != other.storeId) {
			return false;
		}
		if (this.itemId != other.itemId) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.walmart.ecomm.service.entity.InventoryPK[ storeId=" + storeId + ", itemId=" + itemId + " ]";
	}

}
