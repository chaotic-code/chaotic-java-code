package com.ash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ash.dao.UserDetailsDao;
import com.ash.entity.UserLoginData;
import com.ash.model.UserDetailsInfo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailService implements UserDetailsService {

	@Autowired
	UserDetailsDao userDetailsDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("UserDetailService :: loadUserByUsername :: username={}", username);
		UserLoginData userLoginData = userDetailsDao.findUserByEmailId(username);
		return new UserDetailsInfo(userLoginData);
	}

}
