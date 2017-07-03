package com.spring.henallux.dataAccess.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="promotion")
@NamedQueries({
	@NamedQuery(
	name ="findPromotionByIdBrandAndDateOfDay",
			query = "from PromotionEntity p where p.brand.idBrand = :idOfBrand and CURRENT_DATE between p.dateBeginning and p.dateEnd"
			)
})
public class PromotionEntity {

	@Id
	@Column(name="idpromotion")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idPromotion;
	
	@Column(name="datebeginning")
	private Date dateBeginning;
	
	@Column(name="dateend")
	private Date dateEnd;
	
	@Column(name="percentagereduction")
	private Double percentageReduction;

	@JoinColumn(name="idbrand", referencedColumnName="idbrand")
	@ManyToOne
	private BrandEntity brand;
	

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	
	public Integer getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(Integer idPromotion) {
		this.idPromotion = idPromotion;
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
