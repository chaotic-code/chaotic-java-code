package com.ash.dao;

import com.ash.entity.UserLoginData;

public interface UserDetailsDao {

	UserLoginData findUserByEmailId(String emailId);
}
