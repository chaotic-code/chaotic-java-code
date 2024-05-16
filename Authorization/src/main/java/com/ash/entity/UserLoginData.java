package com.ash.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user_login_data")
public class UserLoginData {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long loginId;
	private String emailId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private List<String> authorities = new ArrayList<>();
}
