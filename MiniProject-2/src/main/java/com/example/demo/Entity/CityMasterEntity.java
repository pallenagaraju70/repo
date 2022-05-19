package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CITY_MASTER")
@Data
public class CityMasterEntity {

	@Id
	@Column(name="CITY_ID")
	private Integer CityId;
	
	@Column(name="CITY_NAME")
	private String CityName;
	
	@Column(name="STATE_ID")
	private Integer StateId;

	public Integer getCityId() {
		return CityId;
	}

	public void setCityId(Integer cityId) {
		CityId = cityId;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public Integer getStateId() {
		return StateId;
	}

	public void setStateId(Integer stateId) {
		StateId = stateId;
	}
	
	
}
