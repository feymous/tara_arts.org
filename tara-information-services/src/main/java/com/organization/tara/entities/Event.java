package com.organization.tara.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int eventId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;

	@Column(length = 1000)	
	private String description;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd HH:mm", timezone="IST")
	private Date startTime;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyyMMdd HH:mm", timezone="IST")
	private Date endTime;

	@Column(length = 1000)
	private String venue;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "broucher", referencedColumnName = "id")
	private Image broucher;

	private boolean registrationOpen;

	@Column(length = 1000)
	private String guidelines;

	@OneToMany(mappedBy = "event")
	private List<Video> videos;

	@OneToMany(mappedBy = "event")
	private List<Image> images;

}
