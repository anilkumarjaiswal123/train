package com.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.repository.UserRepository;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	private Logger logger  = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepository userRepository;
	public void findByUserIdPassword(String userId,String password) throws ResourceNotFoundException {
		User user=userRepository.findByUserIdPassword(userId, password);
		if(null==user) {
			logger.error("Invalid Credentials.:-{}",user);
			throw new ResourceNotFoundException("Invalid Credential");
		}	
	}
	
	public User findByUserId(String userId) throws ResourceNotFoundException {
		User user=userRepository.findByUserId(userId);
		if(null==user) {
			logger.error("Invalid Credentials.:-{}",user);
			return null;
			//throw new ResourceNotFoundException("User Id Not Found");
		}	
		return user;
	}

}
