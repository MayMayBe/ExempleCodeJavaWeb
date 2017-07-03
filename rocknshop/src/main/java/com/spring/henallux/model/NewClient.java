package com.spring.henallux.model;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class NewClient {
private Integer idClient;
	
	@NotEmpty
	@Size(max=50)
	@Email
	private String email;
	
	@Size(min=8,max=65)
	@NotEmpty
	private String password;
	
	@Size(min=8,max=65)
	@NotEmpty
	private String confirmPassword;
	
	@NotEmpty
	@Size(max=50)
	private String firstName;
	
	@NotEmpty
	@Size(max=50)
	private String lastName;
	
	@NotEmpty
	@Size(max=25)
	private String telephoneNumber;
	
	@Size(max=36)
	private String mobileNumber;
	
	@NotEmpty
	@Size(max=50)
	private String city;
	
	@NotEmpty
	private String country;
	
	@NotEmpty
	@Size(max=25)
	private String streetName;
	
	@NotEmpty
	@Size(max=8)
	private String streetNumber;
	
	@Size(max=8)
	@NotEmpty
	private String zipcode;
	
	


	
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

	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	
	
	
}
