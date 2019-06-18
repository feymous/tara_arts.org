package com.organization.tara.service;

import org.springframework.stereotype.Service;

import com.organization.tara.entities.Registeration;
import com.organization.tara.visualobjects.ResponseVO;

@Service
public interface RegisterationService {

	ResponseVO register(Registeration registration);

}
