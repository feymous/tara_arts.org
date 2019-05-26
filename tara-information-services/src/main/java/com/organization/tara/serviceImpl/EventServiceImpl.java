package com.organization.tara.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.tara.entities.Event;
import com.organization.tara.service.EventService;

@Service
public class EventServiceImpl implements EventService{

	@Override
	public List<Event> getEvents(String period) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvents(int limit, int skip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvents(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event getEvent(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvents() {
		// TODO Auto-generated method stub
		return null;
	}



	

}
