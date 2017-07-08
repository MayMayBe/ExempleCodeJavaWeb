package com.spring.henallux.sessionAttributeModel;

import java.util.HashMap;

import com.spring.henallux.model.OrderShopLine;

public class ClientAndBasket {
	
	private Integer idClient;
	private String firstName;
	private String lastName;
	private HashMap<String, OrderShopLine> orderShopLines;
	
	public ClientAndBasket(){
		this.idClient = 0;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public HashMap<String, OrderShopLine> getOrderShopLines() {
		return orderShopLines;
	}

	public void setOrderShopLines(HashMap<String, OrderShopLine> orderShopLines) {
		this.orderShopLines = orderShopLines;
	}
	
	

}