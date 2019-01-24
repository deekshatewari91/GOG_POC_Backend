package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserEntity;
import com.example.demo.service.Login;

import ch.qos.logback.classic.Logger;

@Repository
public class OAuthDao {

	static Logger logger = (Logger) LoggerFactory.getLogger(OAuthDao.class);

	private static final String ROLE_ADMIN = "ROLE_ADMIN";
	private static final String ROLE_USER = "ROLE_USER";

	@Autowired
	private LoginRepo logrepos;

	/**
	 * @param username
	 * @return
	 */
	public UserEntity getUserDetails(String username) {

		logger.info("inside OAuthDao->getUserDetails()");

		UserEntity user = new UserEntity();
		List<UserEntity> list = new ArrayList<>();
		Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		try {
			List<Login> logList = (List<Login>) logrepos.findAll();
			for (Login l : logList) {
				if (username.equals(l.getUsername())) {
					user.setUsername(username);
					user.setPassword(l.getPassword());
					list.add(user);
				}
				if (!list.isEmpty()) {
					if (l.getRole().equalsIgnoreCase("Admin")) {
						GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ROLE_ADMIN);
						grantedAuthoritiesList.add(grantedAuthority);
						list.get(0).setGrantedAuthorities(grantedAuthoritiesList);
						return list.get(0);
					} else {
						GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ROLE_USER);
						grantedAuthoritiesList.add(grantedAuthority);
						list.get(0).setGrantedAuthorities(grantedAuthoritiesList);
						return list.get(0);
					}
				}
			}
		} catch (Exception e) {
			logger.error("exception in OAuthDao->getUserDetails()", e);

		}

		return null;

	}

}
