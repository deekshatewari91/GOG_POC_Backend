package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.service.User;

public interface UserRepo extends CrudRepository<User, Integer> 
{
	List<User> findByStatus(Boolean stat);

}
