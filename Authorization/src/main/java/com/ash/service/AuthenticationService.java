package com.ash.service;

import com.ash.request.LoginRequest;
import com.ash.request.SignUpRequest;
import com.ash.response.LoginResponse;

public interface AuthenticationService {

	LoginResponse login(LoginRequest loginRequest);

	LoginResponse signUp(SignUpRequest signUpRequest);
}
