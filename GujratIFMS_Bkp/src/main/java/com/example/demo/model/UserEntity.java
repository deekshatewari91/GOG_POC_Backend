package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserEntity {

	private String Username;
	
	private String Password;
	
	private Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	
	public Collection<GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}
	
	public void setGrantedAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}
	
	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
}

