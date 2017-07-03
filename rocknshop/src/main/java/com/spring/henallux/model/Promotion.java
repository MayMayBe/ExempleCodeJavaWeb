package com.spring.henallux.model;

import java.sql.Date;


public class Promotion {
	
	
	private Integer idPromotion;
	private Brand brand;
	private Date dateBeginning;
	private Date dateEnd;
	private Double percentageReduction;
	
	public Integer getIdPromotion() {
		return idPromotion;
	}
	public void setIdPromotion(Integer idPromotion) {
		this.idPromotion = idPromotion;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Date getDateBeginning() {
		return dateBeginning;
	}
	public void setDateBeginning(Date dateBeginning) {
		this.dateBeginning = dateBeginning;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public Double getPercentageReduction() {
		return percentageReduction;
	}
	public void setPercentageReduction(Double percentageReduction) {
		this.percentageReduction = percentageReduction;
	}
	
	

}
