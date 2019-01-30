package com.example.demo.services;

import java.util.Date;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OAuthDao;
import com.example.demo.exception.ApplicationError;
import com.example.demo.exception.GOGException;
import com.example.demo.model.CustomUser;
import com.example.demo.model.UserEntity;

import ch.qos.logback.classic.Logger;

@Service
public class CustomDetailsService implements UserDetailsService{

	static Logger logger =  (Logger) LoggerFactory.getLogger(CustomDetailsService.class);

	@Autowired
	OAuthDao oauthDao;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		UserEntity userEntity = null;
		try {
			userEntity = oauthDao.getUserDetails(username);
			CustomUser customUser = new CustomUser(userEntity);
			return customUser;
		} catch (Exception e) {
			logger.error("Exception while finding the user with username : "+ username);
			ApplicationError error=new ApplicationError(HttpStatus.BAD_GATEWAY,new Date(),"Error !! user not found !!","HIGH");
			throw new GOGException(error);
		}
	}
}
