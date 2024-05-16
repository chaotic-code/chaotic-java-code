package com.ash.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ash.entity.UserLoginData;
import com.ash.exception.AlreadyExistException;
import com.ash.repository.UserLoginDataRepository;
import com.ash.request.LoginRequest;
import com.ash.request.SignUpRequest;
import com.ash.response.LoginResponse;
import com.ash.security.JwtService;
import com.ash.service.AuthenticationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private final UserLoginDataRepository userLoginDataRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;
	
	private final JwtService jwtService;
	
	private String grantedAuthorities[] = {"Local_Admin", "Normal_User"};
	
	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		log.info("AuthenticationServiceImpl :: login :: request :: {}", loginRequest.getEmailId());
		LoginResponse response = new LoginResponse();
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmailId(), loginRequest.getPassword())); 
        if (authentication.isAuthenticated()) { 
        	UserLoginData existingUser = userLoginDataRepository.findByEmailIdIgnoreCase(loginRequest.getEmailId());
            String token = jwtService.generateToken(existingUser); 
            response.setAuthToken(token);
        }
		return response;
	}

	@Override
	public LoginResponse signUp(SignUpRequest signUpRequest) {
		log.info("AuthenticationServiceImpl :: signUp :: request :: {}", signUpRequest.getEmailId());
		
		UserLoginData existingUser = userLoginDataRepository.findByEmailIdIgnoreCase(signUpRequest.getEmailId());
		if(null != existingUser)
			throw new AlreadyExistException("User already exist with given emailId: " + signUpRequest.getEmailId());
		
		UserLoginData newUser = new UserLoginData();
		BeanUtils.copyProperties(signUpRequest, newUser, "password");
		newUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		
		
		List<String> authorities = new ArrayList<>();
		Random random = new Random();

		int randomNumber = random.nextInt(2);
		authorities.add(grantedAuthorities[randomNumber]);
		newUser.setAuthorities(authorities);
		
		userLoginDataRepository.save(newUser);
		String token = jwtService.generateToken(newUser); 
		
		LoginResponse response = new LoginResponse();
        response.setAuthToken(token);
        return response;
	}
}
