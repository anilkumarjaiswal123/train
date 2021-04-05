package com.demo.model;


import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
public class TrainResponse {
	
	@NotNull(message = "From station should not be Blank")
	@NotEmpty(message ="From station should not be Blank" )
	private String trainFrom;
	
	@NotEmpty(message ="To station should not be Blank" )
	@NotNull(message = "To Station should not be blank")
	private String trainTo;
	
	
	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a date.")
	private java.util.Date journeyDate;

}
