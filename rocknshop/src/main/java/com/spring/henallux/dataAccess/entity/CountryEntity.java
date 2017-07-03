package com.spring.henallux.dataAccess.entity;


import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="country")
public class CountryEntity {
	
	@Id
	@Column(name="idcountry")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idCountry;
	
	@Column(name="countryname")
	private String countryName;
	
	@OneToMany(mappedBy="country", fetch= FetchType.LAZY)
	private Collection<BrandEntity> brands;
	
	

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

	public Collection<BrandEntity> getBrands() {
		return brands;
	}

	public void setBrands(Collection<BrandEntity> brands) {
		this.brands = brands;
	}

	
	
}
