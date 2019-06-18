package com.organization.tara.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.tara.entities.Registeration;
import com.organization.tara.repository.RegisterationRepository;
import com.organization.tara.service.RegisterationService;
import com.organization.tara.visualobjects.ResponseVO;

@Service
public class RegisterationServiceImpl implements RegisterationService{

	@Autowired
	RegisterationRepository registerationRepository;
	
	@Override
	public ResponseVO register(Registeration registration) {
		// TODO Auto-generated method stub
		registerationRepository.save(registration);
		return null;
	}

}
