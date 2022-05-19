package com.example.demo.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRegistrationForm {

	private String FirstName;
	
	private String LastName;
	
	private String email;
	
	private Long phno;
	
	private LocalDate dob;
	
	private String gender;
	
	private String CountryId;
	
	private String StateId;
	
	private String CityId;

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountryId() {
		return CountryId;
	}

	public void setCountryId(String countryId) {
		CountryId = countryId;
	}

	public String getStateId() {
		return StateId;
	}

	public void setStateId(String stateId) {
		StateId = stateId;
	}

	public String getCityId() {
		return CityId;
	}

	public void setCityId(String cityId) {
		CityId = cityId;
	}
	
	
}
