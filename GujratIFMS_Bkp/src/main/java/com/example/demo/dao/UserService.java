package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.service.User;


public interface UserService extends CrudRepository<User,Integer> {

}
