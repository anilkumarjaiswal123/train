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

@Entity
@Table(name = "train")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="train_id")
	private Long trainId;
	
	@Column(name="train_name")
	private String trainName;
	
	@Column(name="train_from")
	private String trainFrom;
	
	@Column(name="train_to")
	private String trainTo;
	
	@Column(name="totalseats")
	private Long totalSeats;
	
	@Column(name="availableseats")
	private Long availableSeats;
	
	@Column(name = "journey_date")
	@Temporal(TemporalType.DATE)
	private Date journeyDate;



}
