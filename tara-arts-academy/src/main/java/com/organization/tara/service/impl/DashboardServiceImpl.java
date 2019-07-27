package com.organization.tara.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.organization.tara.entities.ContactInfo;
import com.organization.tara.entities.Image;
import com.organization.tara.repository.ContactInfoRepository;
import com.organization.tara.repository.ImageRepository;
import com.organization.tara.service.DashboardService;
import com.organization.tara.visualobjects.CascadeImage;
import com.organization.tara.visualobjects.ParticipantDashboardVO;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	ContactInfoRepository contactInfoRepository;

	@Autowired
	ImageRepository imageRepository;

	@Override
	public void postCotactInfo(ContactInfo contactInfo) {
		contactInfo.setPingedDate(new Date());
		contactInfoRepository.save(contactInfo);
	}

	@Override
	public ParticipantDashboardVO participantDashboard() {
		// TODO Auto-generated method stub
		List<Image> images = imageRepository.getCascadeImage(PageRequest.of(0, 5));
		ParticipantDashboardVO participantDashboardVO = new ParticipantDashboardVO();
		List<CascadeImage> cascadeImages = new ArrayList<>();
		for (Image image : images) {
			CascadeImage cascadeImage = new CascadeImage();
			cascadeImage.setId(image.getId());
			cascadeImage.setImageType(image.getType());
			cascadeImage.setUrl(image.getUrl());
			cascadeImage.setUploadedDate(image.getUploadedDate());
			cascadeImages.add(cascadeImage);
		}
		participantDashboardVO.setCascadeImages(cascadeImages);

		return participantDashboardVO;
	}

}
