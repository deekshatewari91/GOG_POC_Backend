package com.example.demo.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CitiesService extends CrudRepository<Cities, Integer> {

public List<Cities> getCitiesBycid(int countryId);

}
