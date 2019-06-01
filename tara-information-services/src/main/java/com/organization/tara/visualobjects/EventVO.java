package com.organization.tara.visualobjects;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EventVO {

	private String eventName;

	@Size(max = 1000)	
	private String description;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="IST")
	private Date startTime;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="IST")
	private Date endTime;

	@Size(max = 1000)
	private String venue;

	private String broucherUrl;

	private boolean registrationOpen;

	@Size(max = 1000)
	private String guidelines;

	private List<String> videoUrls;

	private List<String> imageUrls;
}
