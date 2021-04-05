package com.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
@Entity
@Table(name="user")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long Id;
	
	@Size(min = 2, message = "User Id should be atleast 2 characters")
	@NotNull(message = "User Id should not be blank")
	@Column(name = "user_id")
	private String userId;
	
	@Size(min = 5, message = "User Id should be atleast 5 characters")
	@NotNull(message = "Password should not be blank")
	@Column(name = "user_password")
	private String password;
	
	@Column(name = "user_mobno")
	private Long mobNo;

}
