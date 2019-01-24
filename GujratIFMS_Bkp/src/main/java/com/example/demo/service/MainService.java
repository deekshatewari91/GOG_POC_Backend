package com.example.demo.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.GOGException;

//import com.main.IFMS.service.User;

@Service("userService")
public interface MainService 
{
	String create(User user) throws GOGException;
	
	HashMap<String, String> login(String login);
	
	void updateStatus(List<User> users);
	
	User findUser(int uid);
	
	List<String> findAllFirstName();

	String deleteUser(int id);
    
    List<User> findAll();
	
    List<User> findUserbyStatus(boolean stat);    
    
    void addEmployee(Employee emp,List<Address> addr);
    
    Employee findEmpById(int eid);

}
