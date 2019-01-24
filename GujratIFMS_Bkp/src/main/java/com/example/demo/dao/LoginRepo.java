package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.service.Login;

public interface LoginRepo extends CrudRepository<Login, Integer> {
	
}
