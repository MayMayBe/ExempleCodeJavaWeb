package com.spring.henallux.model;



public class City {

private Integer idCity;
private String cityName;
private Integer zipCode;
private Country country;
public Integer getIdCity() {
	return idCity;
}
public void setIdCity(Integer idCity) {
	this.idCity = idCity;
}
public String getCityName() {
	return cityName;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public Integer getZipCode() {
	return zipCode;
}
public void setZipCode(Integer zipCode) {
	this.zipCode = zipCode;
}
public Country getCountry() {
	return country;
}
public void setCountry(Country country) {
	this.country = country;
}


}
