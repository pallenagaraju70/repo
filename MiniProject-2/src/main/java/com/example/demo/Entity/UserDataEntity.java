package com.example.demo.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name="UserDataDatabase")
@Data
public class UserDataEntity {

	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="FIRST_NAME")
private String FirstName;
	
	@Column(name="LAST_NAME")
	private String LastName;
	
	@Column(name="EMAIL_ID", unique = true)
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PHNO")
	private Long phno;
	
	@Column(name="DOB")
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private LocalDate dob;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="COUNTRY_ID")
	private String CountryId;
	
	@Column(name="STATE_ID")
	private String StateId;
	
	@Column(name="CITY_ID")
	private String CityId;
	
	@Column(name="ACC_STATUS")
	private String Accstatus;
	
	@CreationTimestamp
	@Column(name="CREATED_DATE", updatable = false)
	private LocalDate Createddate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE", insertable = false)
	private LocalDate Updateddate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAccstatus() {
		return Accstatus;
	}

	public void setAccstatus(String accstatus) {
		Accstatus = accstatus;
	}

	public LocalDate getCreateddate() {
		return Createddate;
	}

	public void setCreateddate(LocalDate createddate) {
		Createddate = createddate;
	}

	public LocalDate getUpdateddate() {
		return Updateddate;
	}

	public void setUpdateddate(LocalDate updateddate) {
		Updateddate = updateddate;
	}
	
	
}
