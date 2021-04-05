package com.demo.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Ticket_Info")
public class TicketInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_Id")
	private String userId;
	@Column(name = "train_Id")
	private Long trainId;
	@Column(name = "train_From")
	private String trainFrom;
	@Column(name = "train_To")
	private String trainTo;
	@Column(name = "no_of_seats")
	private Long noOfSeats;
	@Column(name = "journey_Date")
	private Date dateOfJourney;
}
