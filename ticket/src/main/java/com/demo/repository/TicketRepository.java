package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.dto.TicketInfo;

public interface TicketRepository extends JpaRepository<TicketInfo, Long>{

	@Query("SELECT t FROM TicketInfo t WHERE t.userId = ?1")
    List<TicketInfo> findByUserId(String userId );
	
}
