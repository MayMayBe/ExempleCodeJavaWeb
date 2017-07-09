package com.spring.henallux.modelAttribute;

import java.util.HashMap;

import com.spring.henallux.model.OrderShopLine;

public class ClientAndBasket {
	
	private Integer idClient;
	private String email;
	private String firstName;
	private String lastName;
	private String country;
	private HashMap<String, OrderShopLine> orderShopLines;
	
	public void setDefault(){
		this.idClient = 0;
		this.email = null;
		this.firstName = null;
		this.lastName = null;
		this.country = null;
		this.orderShopLines = new HashMap<String, OrderShopLine>();
	}
	
	public ClientAndBasket(){
		this.idClient = 0;
		this.orderShopLines = new HashMap<String, OrderShopLine>();
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}