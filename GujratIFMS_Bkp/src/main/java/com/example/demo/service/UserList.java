package com.example.demo.service;

import java.util.ArrayList;

public class UserList {
	
	private ArrayList<User> userList;
	private int count;
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
