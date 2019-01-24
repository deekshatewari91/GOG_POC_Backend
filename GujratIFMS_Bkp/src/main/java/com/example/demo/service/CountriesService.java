package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.service.Countries;

public interface CountriesService extends CrudRepository<Countries, Integer> {

}
