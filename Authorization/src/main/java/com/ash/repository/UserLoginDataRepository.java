package com.ash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ash.entity.UserLoginData;

@Repository
public interface UserLoginDataRepository extends JpaRepository <UserLoginData, Long>{

	UserLoginData findByEmailIdIgnoreCase(String emailId);
}
