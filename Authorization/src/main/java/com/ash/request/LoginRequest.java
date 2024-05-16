package com.ash.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

	@NotBlank(message="emailId can't be null or empty.")
	private String emailId;
	
	@NotBlank(message="password can't be null or empty.")
	private String password;
}
