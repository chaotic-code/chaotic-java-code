package com.ash.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

	private String emailId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
}
