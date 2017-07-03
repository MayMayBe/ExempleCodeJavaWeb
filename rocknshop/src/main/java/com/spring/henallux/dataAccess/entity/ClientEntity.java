package com.spring.henallux.dataAccess.entity;


import javax.persistence.*;


@Entity
@Table(name="client")
@NamedQueries({
	@NamedQuery(
		name = "updateClientPassword",
		query = "from ModelEntity m where m.category.id = :idcategory and m.type = :idtype"
	)
})
public class ClientEntity {

	@Id
	@Column(name="idclient")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idClient;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="telephonenumber")
	private String telephoneNumber;
	
	@Column(name="mobilenumber")
	private String mobileNumber;
	
	@Column(name="streetname")
	private String streetName;
	
	@Column(name="streetnumber")
	private String streetNumber;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="city")
	private String city;
	
	@JoinColumn(name="idcountry",referencedColumnName="idcountry")
	@ManyToOne
	private CountryEntity country;

	public CountryEntity getCountry() {
		return country;
	}
	

	public String getStreetNumber() {
		return streetNumber;
	}


	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String address) {
		this.streetName = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}




	
}
