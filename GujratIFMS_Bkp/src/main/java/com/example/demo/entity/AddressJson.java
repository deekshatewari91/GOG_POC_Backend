package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address_json")
public class AddressJson {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;

	private String houseNo;

	private String steetNo;

	private String city;

	private String country;

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getSteetNo() {
		return steetNo;
	}	

	public void setSteetNo(String steetNo) {
		this.steetNo = steetNo;
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

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", houseNo=" + houseNo + ", steetNo=" + steetNo + ", city=" + city + ", country="
				+ country + "]";
	}


}
