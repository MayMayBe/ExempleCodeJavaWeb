package com.spring.henallux.modelAttribute;


import org.hibernate.validator.constraints.NotEmpty;

public class UpdateClientForm {


	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String telephoneNumber;
	
	private String mobileNumber;
	
	@NotEmpty
	private String city;
	
	@NotEmpty
	private String country;
	
	@NotEmpty
	private String streetName;
	
	@NotEmpty
	private String streetNumber;
	
	@NotEmpty
	private String zipcode;
	

	public UpdateClientForm(){};
	
	
	public UpdateClientForm(String firstName, String lastName, String telephoneNumber, String mobileNumber, String city,
			String country, String streetName, String streetNumber, String zipcode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
		this.mobileNumber = mobileNumber;
		this.city = city;
		this.country = country;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String address) {
		this.streetName = address;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
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
	
	
}
