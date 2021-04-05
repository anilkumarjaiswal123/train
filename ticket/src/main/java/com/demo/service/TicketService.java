package com.demo.service;

import java.util.List;

import com.demo.dto.TicketDetails;
import com.demo.dto.TicketInfo;

public interface TicketService {
	
	public TicketInfo bookTicket(TicketDetails ticketDetails);
	
	public List<TicketInfo> ticketHistory(String userId);

}
