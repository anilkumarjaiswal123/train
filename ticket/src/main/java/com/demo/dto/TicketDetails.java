package com.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class TicketDetails {
	@NotNull(message = "User Id should not be Blank")
    @NotEmpty(message ="User Id should not be Blank" )
	private String userId;
	
	@Min(100)
	@NotNull(message = "Train Id should not be Blank")
	private Long trainId;
	
	@Min(1)
	@NotNull(message = "No Of seats should not be Blank")
	private Long noOfSeats;
}
