package com.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
public class Train {
	
	
	private Long id;
	
	
	private Long trainId;
	
	
	private String trainName;
	
	
	private String trainFrom;
	
	
	private String trainTo;
	
	
	private Long totalSeats;
	
	
	private Long availableSeats;
	
	
	private Date journeyDate;



}
