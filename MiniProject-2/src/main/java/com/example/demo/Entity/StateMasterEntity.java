package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="State_Master")
@Data
public class StateMasterEntity {

	@Id
	@Column(name="STATE_ID")
	private Integer stateId;
	
	@Column(name="STATE_NAME")
	private String StateName;
	
	@Column(name="COUNTRY_ID")
	private Integer CountryId;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return StateName;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public Integer getCountryId() {
		return CountryId;
	}

	public void setCountryId(Integer countryId) {
		CountryId = countryId;
	}
	
	
}
