package com.spring.henallux.model;

import javax.validation.constraints.*;

public class OrderShopLine {
	
	private Integer idOrderShopLine;
	
	@NotNull
	@Min(value=1)
	private Integer numberLine;
	
	@NotNull
	private OrderShop orderShop;
	
	@NotNull
	@Min(value=1)
	@Max(value=10)
	private Integer quantity;
	
	@NotNull
	@DecimalMin("0.00")
	private Double realPrice;
	
	@NotNull
	@DecimalMin("0.00")
	private Double percentageDiscount;
	
	@NotNull
	private Model model;
	
	
	
	public Double getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(Double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
	}

	public void addQuantity(int addQuantity){
		this.quantity += addQuantity;
	}
	
	public Integer getIdOrderShopLine() {
		return idOrderShopLine;
	}
	public void setIdOrderShopLine(Integer idOrderShopLine) {
		this.idOrderShopLine = idOrderShopLine;
	}
	public Integer getNumberLine() {
		return numberLine;
	}
	public void setNumberLine(Integer numberLine) {
		this.numberLine = numberLine;
	}
	public OrderShop getOrderShop() {
		return orderShop;
	}
	public void setOrderShop(OrderShop orderShop) {
		this.orderShop = orderShop;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(Double realPrice) {
		this.realPrice = realPrice;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
	
	
	
	
	
}
