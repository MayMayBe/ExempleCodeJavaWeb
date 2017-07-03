package com.spring.henallux.model;

import java.util.Collection;

public class Model {

	private Integer idModel;
	private String nameModel;
	private Boolean fretless;
	private Integer nbStrings;
	private Double price;
	private Characteristic type;
	private Category category;
	private Brand brand;
	private Description description;
	private Collection<OrderShopLine> orderShopLines;
	public Integer getIdModel() {
		return idModel;
	}
	public void setIdModel(Integer idModel) {
		this.idModel = idModel;
	}
	public String getNameModel() {
		return nameModel;
	}
	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
	}
	public Boolean getFretless() {
		return fretless;
	}
	public void setFretless(Boolean fretless) {
		this.fretless = fretless;
	}
	public Integer getNbStrings() {
		return nbStrings;
	}
	public void setNbStrings(Integer nbStrings) {
		this.nbStrings = nbStrings;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Characteristic getType() {
		return type;
	}
	public void setType(Characteristic type) {
		this.type = type;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	public Collection<OrderShopLine> getOrderShopLines() {
		return orderShopLines;
	}
	public void setOrderShopLines(Collection<OrderShopLine> orderShopLines) {
		this.orderShopLines = orderShopLines;
	}
	
	
	
}
