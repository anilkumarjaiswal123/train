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
public class BookTicket {
	private Long id;
	private Long trainId;
	private String trainName;
	private String trainFrom;
	private String trainTo;
	private Long totalSeats;
	private Long availableSeats;
	private Long bookedSeats;
	private String info;
	//private UserResponse userResponse;
	
}
