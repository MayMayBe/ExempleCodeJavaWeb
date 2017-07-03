package com.spring.henallux.dataAccess.entity;


import java.util.Collection;

import javax.persistence.*;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;


@Entity
@Indexed
@Table(name="model")
@NamedQueries({
	@NamedQuery(
		name = "findModelsByCategoryAndType",
		query = "from ModelEntity m where m.category.id = :idcategory and m.type = :idtype"
	),
	@NamedQuery(
		name = "findModelsByCategory",
		query = "from ModelEntity m where m.category.id = :idcategory"
	)
})
public class ModelEntity {

	@Id
	@Column(name="idmodel")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idModel;
	
	@Field(index=org.hibernate.search.annotations.Index.YES, analyze=Analyze.YES, store=org.hibernate.search.annotations.Store.NO)
	@Column(name="namemodel")
	private String nameModel;
	
	@Column(name="fretless")
	private Boolean fretless;
	
	@Field(index=org.hibernate.search.annotations.Index.YES, analyze=Analyze.YES, store=org.hibernate.search.annotations.Store.NO)
	@Column(name="nbstrings")
	private Integer nbStrings;
	
	@Column(name="price")
	private Double price;
	
	@IndexedEmbedded
	@JoinColumn(name="idbrand",referencedColumnName="idbrand")
	@ManyToOne
	private BrandEntity brand;
	
	@JoinColumn(name="idtype", referencedColumnName="idtype")
	@ManyToOne
	private CharacteristicEntity type;
	
	@JoinColumn(name="idcategory", referencedColumnName="idcategory")
	@ManyToOne
	private CategoryEntity category;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="iddescription",referencedColumnName="iddescription")
	private DescriptionEntity description;

	
	@OneToMany(mappedBy="model", fetch = FetchType.LAZY)
	private Collection<OrderShopLineEntity> orderShopLines;

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

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public CharacteristicEntity getType() {
		return type;
	}

	public void setType(CharacteristicEntity type) {
		this.type = type;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public DescriptionEntity getDescription() {
		return description;
	}

	public void setDescription(DescriptionEntity description) {
		this.description = description;
	}

	public Collection<OrderShopLineEntity> getOrderShopLines() {
		return orderShopLines;
	}

	public void setOrderShopLines(Collection<OrderShopLineEntity> orderShopLines) {
		this.orderShopLines = orderShopLines;
	}
	

}
