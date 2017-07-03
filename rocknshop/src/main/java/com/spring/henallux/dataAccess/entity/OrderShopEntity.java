package com.spring.henallux.dataAccess.entity;



import javax.persistence.*;


@Entity
@Table(name="ordershop")
@NamedQueries({
	@NamedQuery(
		name = "findOrderByIdClient",
		query = "from OrderShopEntity o where o.client.idClient = :id"
	)
})
public class OrderShopEntity {

	@Id
	@Column(name="numberordershop")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer numberOrderShop;
	
	@Column(name="dateordershop")
	private java.util.Date dateOrderShop;
	
	@Column(name="ordershopsent")
	private Boolean orderShopSent;
	
	@JoinColumn(name="idclient", referencedColumnName="idclient")
	@ManyToOne
	private ClientEntity client;
	
	@Column(name="typepayment")
	private String typePayment;
	
	@Column(name="paymentdone")
	private Boolean paymentDone;
	
	
	public String getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}

	public Boolean getPaymentDone() {
		return paymentDone;
	}

	public void setPaymentDone(Boolean paymentDone) {
		this.paymentDone = paymentDone;
	}

	public Integer getNumberOrderShop() {
		return numberOrderShop;
	}

	public void setNumberOrderShop(Integer numberOrderShop) {
		this.numberOrderShop = numberOrderShop;
	}

	public java.util.Date getDateOrderShop() {
		return dateOrderShop;
	}

	public void setDateOrderShop(java.util.Date dateOrderShop) {
		this.dateOrderShop = dateOrderShop;
	}

	public Boolean getOrderShopSent() {
		return orderShopSent;
	}

	public void setOrderShopSent(Boolean orderShopSent) {
		this.orderShopSent = orderShopSent;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}
	
	
}
