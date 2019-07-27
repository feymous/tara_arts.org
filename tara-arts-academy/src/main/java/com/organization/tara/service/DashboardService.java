package com.organization.tara.service;

import com.organization.tara.entities.ContactInfo;
import com.organization.tara.visualobjects.ParticipantDashboardVO;

public interface DashboardService {

	void postCotactInfo(ContactInfo contactInfo);

	ParticipantDashboardVO participantDashboard();

}
