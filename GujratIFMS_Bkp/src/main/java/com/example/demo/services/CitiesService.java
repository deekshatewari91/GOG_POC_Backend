package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Cities;
import com.example.demo.exception.GOGException;


public interface CitiesService {
	
	public List<Cities> getCities(int id) throws GOGException;

}
