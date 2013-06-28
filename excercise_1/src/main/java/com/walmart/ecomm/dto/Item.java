package com.walmart.ecomm.dto;

public class Item {
	//POJO for Item
	//MOck the Response JSON

	long item_id;

	public long getItem_id() {
		return item_id;
	}

	public void setItem_id(long item_id) {
		this.item_id = item_id;
	}

	@Override
	public String toString() {
		return "{ \"item_id\":"+item_id+", \"locale_id\":100, \"inventory Element\":[ { \"Store\":\"sanjose\" }, { \"Store\":\"Sunnyvale\" } ], \"pricing Element\":[ { \"total_cost\":10, \"currency\":\"usd\" }, { \"total_cost\":20, \"currency\":\"euro\" } ], \"description\":\"XYZ\" }";
	}
}

