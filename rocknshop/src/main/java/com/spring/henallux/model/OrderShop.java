package com.spring.henallux.model;



public class OrderShop {
	

	private Integer numberOrderShop;
	

	private java.util.Date dateOrderShop;
	

	private Boolean orderShopSent;
	

	private Client client;
	

	private String typePayment;
	
	

	private Boolean paymentDone;
	

	//private HashMap<String, OrderShopLine> orderShopLines;
	
	
	public String getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}

	/*public void setNewOrderLineShopInCollection(String model, OrderShopLine orderShopLine){
		orderShopLines.put(model, orderShopLine);
	}*/
	
	public Integer getNumberOrderShop() {
		return numberOrderShop;
	}
	public void setNumberOrderShop(Integer numberOrderShop) {
		this.numberOrderShop = numberOrderShop;
	}
	public java.util.Date getDateOrderShop() {
		return dateOrderShop;
	}
	public void setDateOrderShop(java.util.Date dateOrderShop) {
		this.dateOrderShop = dateOrderShop;
	}
	public Boolean getOrderShopSent() {
		return orderShopSent;
	}
	public void setOrderShopSent(Boolean orderShopSent) {
		this.orderShopSent = orderShopSent;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	/*public HashMap<String, OrderShopLine> getOrderShopLines() {
		return orderShopLines;
	}

	public void setOrderShopLines(HashMap<String, OrderShopLine> orderShopLines) {
		this.orderShopLines = orderShopLines;
	}*/



	public Boolean getPaymentDone() {
		return paymentDone;
	}

	public void setPaymentDone(Boolean paymentDone) {
		this.paymentDone = paymentDone;
	}

	
	
}
