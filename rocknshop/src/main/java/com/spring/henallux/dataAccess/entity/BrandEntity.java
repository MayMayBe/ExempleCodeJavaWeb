package com.spring.henallux.dataAccess.entity;


import java.util.Collection;

import javax.persistence.*;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Indexed
@Entity
@Table(name="brand")
public class BrandEntity {

	@Id
	@Column(name="idbrand")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idBrand;
	
	@Field(index=org.hibernate.search.annotations.Index.YES, analyze=Analyze.YES, store=org.hibernate.search.annotations.Store.NO)
	@Column(name="namebrand")
	private String nameBrand;
	
	@JoinColumn(name="idcountry", referencedColumnName="idcountry")
	@ManyToOne
	private CountryEntity country;
	
	
	@ContainedIn
	@OneToMany(mappedBy="brand",fetch = FetchType.LAZY)
	private Collection<ModelEntity> models;
	
	@OneToMany(mappedBy="brand", fetch = FetchType.LAZY)
	private Collection<PromotionEntity> promotions;
	
	public Collection<PromotionEntity> getPromotions() {
		return promotions;
	}

	public void setPromotions(Collection<PromotionEntity> promotions) {
		this.promotions = promotions;
	}

	public Collection<ModelEntity> getModels() {
		return models;
	}

	public void setModels(Collection<ModelEntity> models) {
		this.models = models;
	}

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

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	
	
}
