package com.spring.henallux.sessionAttributeModel;

import java.util.HashMap;

import com.spring.henallux.model.OrderShopLine;

public class ClientBasket {

	private HashMap<String, OrderShopLine> orderShopLines;
	
	public ClientBasket(){
		this.orderShopLines = new HashMap<>();
	}
	
	public void clearClientBasket(){
		this.orderShopLines.clear();
	}

	public HashMap<String, OrderShopLine> getOrderShopLines() {
		return orderShopLines;
	}

	public void setOrderShopLines(HashMap<String, OrderShopLine> orderShopLines) {
		this.orderShopLines = orderShopLines;
	}
	
	public void setNewOrderLineShopInCollection(String model, OrderShopLine orderShopLine){
		this.orderShopLines.put(model, orderShopLine);
	}
	
	
}
