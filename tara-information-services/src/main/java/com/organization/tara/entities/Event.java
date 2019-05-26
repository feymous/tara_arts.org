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

import lombok.Data;

@Entity
@Data
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int eventId;

	private String name;

	private String description;

	private Date startTime;

	private Date endTime;

	private String type;

	private String venue;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "broucher", referencedColumnName="id")
	private Image broucher;

	private boolean registrationOpen;

	private String guidelines;

	@OneToMany(mappedBy = "event")
	private List<Video> videos;

	@OneToMany(mappedBy = "event")
	private List<Image> images;

}
