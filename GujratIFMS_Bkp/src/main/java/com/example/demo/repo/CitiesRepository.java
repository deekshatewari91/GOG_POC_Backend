package com.example.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Cities;

public interface CitiesRepository extends CrudRepository<Cities, Integer> {

public List<Cities> getCitiesBycid(int countryId);

}
