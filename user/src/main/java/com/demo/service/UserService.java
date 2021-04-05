package com.demo.service;

import com.demo.dto.User;

public interface UserService {
	public void findByUserIdPassword(String userId,String password);
	public User findByUserId(String userId);
}
