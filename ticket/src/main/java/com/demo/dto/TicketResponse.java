package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketResponse {

	private Long id;
	private Long trainId;
	private String trainName;
	private String trainFrom;
	private String trainTo;
	private String info;
	
}
