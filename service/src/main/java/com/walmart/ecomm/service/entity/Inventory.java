
package com.walmart.ecomm.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author vrangan
 */
@Entity
@Table(name = "inventory")

public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected InventoryPK inventoryPK;
	@Size(max = 45)
	@Column(name = "ITEM_QUANTITY")
	private String itemQuantity;
	@Size(max = 45)
	@Column(name = "ITEM_PRICE")
	private String itemPrice;
	@Size(max = 45)
	@Column(name = "ITEM_CURRENCY")
	private String itemCurrency;
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
	@ManyToOne(optional = false)
	private Item item;
	@JoinColumn(name = "STORE_ID", referencedColumnName = "STORE_ID")
	@ManyToOne(optional = false)
	private Store store;

	public Inventory() {
	}

	public Inventory(InventoryPK inventoryPK) {
		this.inventoryPK = inventoryPK;
	}

	public Inventory(int storeId, int itemId) {
		this.inventoryPK = new InventoryPK(storeId, itemId);
	}

	public InventoryPK getInventoryPK() {
		return inventoryPK;
	}

	public void setInventoryPK(InventoryPK inventoryPK) {
		this.inventoryPK = inventoryPK;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCurrency() {
		return itemCurrency;
	}

	public void setItemCurrency(String itemCurrency) {
		this.itemCurrency = itemCurrency;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (inventoryPK != null ? inventoryPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Inventory)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "com.walmart.ecomm.service.entity.Inventory[ inventoryPK=" + inventoryPK + " ]";
	}

}
