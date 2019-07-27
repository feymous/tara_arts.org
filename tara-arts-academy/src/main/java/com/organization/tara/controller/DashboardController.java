package com.organization.tara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.tara.entities.ContactInfo;
import com.organization.tara.service.DashboardService;
import com.organization.tara.visualobjects.ParticipantDashboardVO;

@RestController
public class DashboardController {
	
	@Autowired
	DashboardService dashboardService;
	
	@PostMapping(path = "/contact") 
	public void postCotactInfo(@RequestBody ContactInfo contactInfo) {
		 dashboardService.postCotactInfo(contactInfo);
	}
	
	@GetMapping(path = "/participant/dashboard") 
	public ParticipantDashboardVO participantDashboard() {
		 return dashboardService.participantDashboard();
	}
}
