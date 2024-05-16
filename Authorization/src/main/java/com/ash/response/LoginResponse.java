package com.ash.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
	
	private String authToken;
	private String refreshToken;
}
