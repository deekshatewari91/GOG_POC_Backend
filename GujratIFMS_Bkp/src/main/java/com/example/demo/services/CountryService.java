package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Countries;
import com.example.demo.exception.GOGException;

public interface CountryService {
	
	public List<Countries> getCountries() throws GOGException;

}
