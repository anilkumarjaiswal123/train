package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.dto.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.userId = ?1 and u.password=?2")
    User findByUserIdPassword(String userId,String password);
	
    User findByUserId(String userId);
}
