package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.service.Employee;

public interface EmployeeRepo  extends CrudRepository<Employee, Integer> 
{
	List<Employee> findById(int aid);

}
