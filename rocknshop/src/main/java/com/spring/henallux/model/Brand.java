package com.spring.henallux.model;

import java.util.Collection;



public class Brand {
	private Integer idBrand;
	private String nameBrand;
	private Country country;
	private Collection<Model> models;
	private Collection<Promotion> promotions;
	
	public Integer getIdBrand() {
		return idBrand;
	}
	public void setIdBrand(Integer idBrand) {
		this.idBrand = idBrand;
	}
	public String getNameBrand() {
		return nameBrand;
	}
	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Collection<Model> getModels() {
		return models;
	}
	public void setModels(Collection<Model> models) {
		this.models = models;
	}
	public Collection<Promotion> getPromotions() {
		return promotions;
	}
	public void setPromotions(Collection<Promotion> promotions) {
		this.promotions = promotions;
	}
	
	
}
