package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.BookTicket;
import com.demo.dto.TicketDetails;
import com.demo.dto.TicketInfo;
import com.demo.dto.TicketResponse;
import com.demo.dto.Train;
import com.demo.dto.TrainResponse;
import com.demo.feignclient.TicketClient;
import com.demo.service.TicketService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/tickets")
@Validated
public class TicketController {
	
	private Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired
	TicketClient ticketClient;
	
	@Autowired
	
	TicketService ticketService;
		
	@PostMapping("bookTicket")
	public TicketInfo bookTicket(@Valid @RequestBody TicketDetails ticketDetails) {
		logger.info("Booking ticket is being called for service:{}",ticketDetails);
		TicketInfo ticketInfo=ticketService.bookTicket(ticketDetails);
		return ticketInfo;
	}
	
	@GetMapping("ticketHistory/{userId}")
	public List<TicketInfo> ticketHistory(@PathVariable @Valid @NotBlank String userId) {
		logger.info("ticket history is being called for service:{}",userId);
		List<TicketInfo> ticketInfo=ticketService.ticketHistory(userId);
		return ticketInfo;
	}
	
	
}
