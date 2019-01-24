package com.example.demo.service;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Countries implements Serializable {
	
	@Id
	private int id;
	
	@Column(name="country_name")
	private String cname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Countries [id=" + id + ", cname=" + cname + "]";
	}
	
	
}
