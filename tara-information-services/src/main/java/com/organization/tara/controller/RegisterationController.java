package com.organization.tara.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.tara.entities.Registeration;
import com.organization.tara.service.RegisterationService;
import com.organization.tara.visualobjects.ResponseVO;

@RestController
public class RegisterationController {
	
	@Autowired
	RegisterationService registrationService;
	
	@PostMapping("/event/{eventId}/registerations/")
	public ResponseVO register(@PathVariable int eventId, @RequestBody Registeration registration ) {
		
		return registrationService.register(registration);
	}

}
