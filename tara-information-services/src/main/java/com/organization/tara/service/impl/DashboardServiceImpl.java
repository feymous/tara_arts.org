package com.organization.tara.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.tara.entities.ContactInfo;
import com.organization.tara.repository.ContactInfoRepository;
import com.organization.tara.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	ContactInfoRepository contactInfoRepository;

	@Override // TODO Auto-generated method stub
	public void postCotactInfo(ContactInfo contactInfo) {
		contactInfo.setPingedDate(new Date());
		contactInfoRepository.save(contactInfo);
	}

}
