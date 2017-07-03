package com.spring.henallux.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="ordershopline", uniqueConstraints={@UniqueConstraint(columnNames = {"numberline" , "numberordershop"})})
public class OrderShopLineEntity {

	@Id
	@Column(name="idordershopline")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idOrderShopLine;
	
	@Column(name="numberline")
	private Integer numberLine;
	
	@JoinColumn(name="numberordershop", referencedColumnName="numberordershop")
	@ManyToOne
	private OrderShopEntity orderShop;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="realprice")
	private Double realPrice;
	
	@Column(name="percentagediscount")
	private Double percentageDiscount;
	
	@JoinColumn(name="idmodel", referencedColumnName="idmodel")
	@ManyToOne
	private ModelEntity model;
	
	

	public Double getPercentageDiscount() {
		return percentageDiscount;
	}

	public void setPercentageDiscount(Double percentageDiscount) {
		this.percentageDiscount = percentageDiscount;
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

	public OrderShopEntity getOrderShop() {
		return orderShop;
	}

	public void setOrderShop(OrderShopEntity orderShop) {
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

	public ModelEntity getModel() {
		return model;
	}

	public void setModel(ModelEntity model) {
		this.model = model;
	}


	
}
