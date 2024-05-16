package com.ash.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ash.request.LoginRequest;
import com.ash.request.SignUpRequest;
import com.ash.response.LoginResponse;
import com.ash.service.AuthenticationService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("${base-url}")
public class AuthenticationController {

	private final AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request ) {
		LoginResponse response = authenticationService.login(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<LoginResponse> addNewUser(@RequestBody SignUpRequest signUpRequest) {
		LoginResponse response =  authenticationService.signUp(signUpRequest);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getStatus")
	@PreAuthorize("hasAnyAuthority('Local_Admin')")
	public String getStatus() throws InterruptedException{
		return "Success";
	}
	
	@GetMapping("/checkDownTime")
	@PreAuthorize("hasAnyAuthority('Normal_User')")
	public String checkDownTime() throws InterruptedException{
		return "UP";
	}
}
