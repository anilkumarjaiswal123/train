package com.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.User;
import com.demo.model.Login;
import com.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/test")
	public String test() {
		return "I am anil";
	}
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@PostMapping("/userLogin")
    public String userLogin(@Valid @RequestBody Login login){
		logger.info("user Login for service name: {} "+login);
        userService.findByUserIdPassword(login.getUserId(),login.getPassword());
        String message="Login success";
        return message;
    }
	
	@GetMapping("findByUserId/{userId}")
	public User findByUserId(@PathVariable String userId) {
		//System.out.println("user id 123----"+userId);
		User user=userService.findByUserId(userId);
		return user;
	}

}
