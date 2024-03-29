package com.spring.henallux.model;

public class Client{

	private Integer idClient;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String telephoneNumber;
	private String mobileNumber;
	private String streetName;
	private String streetNumber;
	private String zipcode;
	private String city;
	private Country country;
	
	
	public Client(){}
	
	

	
	
	public Client(String firstName, String lastName, String email, String password, String telephoneNumber,
			String mobileNumber, String streetName, String streetNumber, String zipcode, String city, Country country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.telephoneNumber = telephoneNumber;
		this.mobileNumber = mobileNumber;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
}
