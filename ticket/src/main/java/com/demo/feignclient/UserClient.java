package com.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.dto.User;

@FeignClient(value = "user-service", url = "http://localhost:8300/users")


public interface UserClient {
	
	@GetMapping("findByUserId/{userId}")
	public User findByUserId(@PathVariable String userId);
}
