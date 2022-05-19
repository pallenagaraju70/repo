package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Country_Master")
public class CountryMasterEntity {

	@Id
	@Column(name="COUNTRY_ID")
	private Integer CountryId;
	
	@Column(name="COUNTRY_NAME")
	private String CountryName;

	public Integer getCountryId() {
		return CountryId;
	}

	public void setCountryId(Integer countryId) {
		CountryId = countryId;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
	
	
	
}
