package com.example.demo.service;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee 
{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO) // to get auto increment in ID value starting from 1.
	private int id;
	private String firstName;
	private String lastName;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="employee",cascade = CascadeType.ALL)
	List<Address> addr;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<Address> getAddr() {
		return addr;
	}
	public void setAddr(List<Address> addr) {
		this.addr = addr;
	}

	
}
