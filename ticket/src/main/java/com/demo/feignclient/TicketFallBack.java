package com.demo.feignclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.demo.dto.BookTicket;
import com.demo.dto.TicketResponse;
import com.demo.dto.TrainResponse;

@Component
@ComponentScan
class TicketFallback 
{
    
    public List<TicketResponse> trainSearch(TrainResponse trainResponse) {
        return new ArrayList<>();
    }
    
    public BookTicket bookTicket(Long trainId, Long noOfSeats) {
    	System.out.println("Fal Back Method-----");
           return new BookTicket();	
    }
    
}
