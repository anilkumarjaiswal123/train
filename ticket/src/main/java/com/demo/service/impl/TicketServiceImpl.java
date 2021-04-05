package com.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.TicketDetails;
import com.demo.dto.TicketInfo;
import com.demo.dto.Train;
import com.demo.dto.User;
import com.demo.exception.ResourceNotFoundException;
import com.demo.feignclient.TicketClient;
import com.demo.feignclient.UserClient;
import com.demo.repository.TicketRepository;
import com.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService{
	private Logger logger  = LoggerFactory.getLogger(TicketServiceImpl.class);
	@Autowired
	TicketClient ticketClient;
	
	@Autowired
	UserClient userClient;
	
	@Autowired
	TicketRepository ticketRepository;

  @Override
  public TicketInfo bookTicket(TicketDetails ticketDetails){
	  
	 Train train=ticketClient.findByTrainId(ticketDetails.getTrainId());
	
	 User user=userClient.findByUserId(ticketDetails.getUserId());
	 if(null==train) {
		 logger.error("Train not found for the Id:{}",train);
		 throw new ResourceNotFoundException("Train  not found for Id "+ticketDetails.getTrainId());
	 }
	 if(null==user) {
		 logger.error("User not found for the Id:{}",user);
		 throw new ResourceNotFoundException("User  not found for this Id "+ticketDetails.getUserId());	 
	 }
	 
	 TicketInfo ticketInfo=new TicketInfo();
	 ticketInfo.setUserId(user.getUserId());
	 ticketInfo.setTrainId(train.getTrainId());
	 ticketInfo.setNoOfSeats(ticketDetails.getNoOfSeats());
	 ticketInfo.setTrainFrom(train.getTrainFrom());
	 ticketInfo.setTrainTo(train.getTrainTo());
	 ticketInfo.setDateOfJourney(train.getJourneyDate());
	 ticketRepository.save(ticketInfo);
	 return ticketInfo;
  }
  
  @Override
  public List<TicketInfo> ticketHistory(String userId) {
	  List<TicketInfo> ticketInfo=ticketRepository.findByUserId(userId);
	  if(ticketInfo.isEmpty()) {
		  logger.error("User not found for the Id:{}",userId);
		  throw new ResourceNotFoundException("user does not exist for this id "+userId);
	  }
	  return ticketInfo;
  }

}
