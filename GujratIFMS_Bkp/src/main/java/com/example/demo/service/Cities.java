package com.example.demo.service;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cities implements Serializable{
	
	@Id
	private int id;
	
	@Column(name="country_id")
	private int cid;
	
	@Column(name="city_name")
	private String cname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Cities [id=" + id + ", sid=" + cid + ", cname=" + cname + "]";
	}

	
	
}
