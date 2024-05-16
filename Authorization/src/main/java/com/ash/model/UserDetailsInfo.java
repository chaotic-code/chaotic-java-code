package com.ash.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ash.entity.UserLoginData;

public class UserDetailsInfo implements UserDetails {

	private static final long serialVersionUID = 7044373329380757851L;
	
	private String emailId;
	private String password;
	private List<GrantedAuthority> authorities; 
	
	public UserDetailsInfo(UserLoginData userLoginData) {
		emailId = userLoginData.getEmailId();
		password = userLoginData.getPassword();
		authorities = userLoginData.getAuthorities().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return emailId;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
