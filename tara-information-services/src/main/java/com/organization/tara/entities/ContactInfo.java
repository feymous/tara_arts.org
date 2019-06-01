package com.organization.tara.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	private String firstName;

	private String lastName;

	private String emailId;

	private String phoneNo;

	@Column(length = 2000)
	private String message;
	
	private Date pingedDate;
}
