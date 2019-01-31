package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address 
{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO) // to get auto increment in ID value starting from 1.
	private int aid;
	private String __Adrs___hno;
	private String __Adrs___city;
	private String __Adrs___state;
	
	@ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "id")
    private Employee employee;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String get__Adrs___hno() {
		return __Adrs___hno;
	}

	public void set__Adrs___hno(String __Adrs___hno) {
		this.__Adrs___hno = __Adrs___hno;
	}

	public String get__Adrs___city() {
		return __Adrs___city;
	}

	public void set__Adrs___city(String __Adrs___city) {
		this.__Adrs___city = __Adrs___city;
	}

	public String get__Adrs___state() {
		return __Adrs___state;
	}

	public void set__Adrs___state(String __Adrs___state) {
		this.__Adrs___state = __Adrs___state;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
