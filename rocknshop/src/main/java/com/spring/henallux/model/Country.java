package com.spring.henallux.model;

import java.util.Collection;


public class Country {
	private Integer idCountry;
	private String countryName;
	
	private Collection<Brand> brands;

	public Country(){};
	public Country(int id, String n){
		idCountry = id;
		countryName = n;
	}
	
	public Country(String n){
		countryName = n;
	}
	
	public Integer getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Integer idCountry) {
		this.idCountry = idCountry;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Collection<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Collection<Brand> brands) {
		this.brands = brands;
	}

}
