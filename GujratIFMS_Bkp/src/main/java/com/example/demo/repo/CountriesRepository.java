package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Countries;

public interface CountriesRepository extends CrudRepository<Countries, Integer> {

}
