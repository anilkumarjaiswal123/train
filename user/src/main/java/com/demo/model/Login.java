package com.demo.model;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

public class Login {
	@NotNull
	@NotEmpty(message = "User Id should not be blank")
	private String userId;
	@NotNull
	@NotEmpty(message = "Password should not be blank")
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
