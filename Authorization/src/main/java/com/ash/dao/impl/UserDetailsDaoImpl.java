package com.ash.dao.impl;

import org.springframework.stereotype.Component;

import com.ash.dao.UserDetailsDao;
import com.ash.entity.UserLoginData;
import com.ash.exception.NotFoundException;
import com.ash.repository.UserLoginDataRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserDetailsDaoImpl implements UserDetailsDao{

	private final UserLoginDataRepository userLoginDataRepository;
	
	@Override
	public UserLoginData findUserByEmailId(String emailId) {
		log.info("UserDetailsDaoImpl :: findUserByEmailId :: Request :: emailId={}", emailId);
		UserLoginData userLoginData = userLoginDataRepository.findByEmailIdIgnoreCase(emailId);
		if(null == userLoginData)
			throw new NotFoundException("User doesn't with given username.");
		
		return userLoginData;
	}

}
