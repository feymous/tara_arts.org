package com.organization.tara.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.organization.tara.entities.Event;
import com.organization.tara.repository.EventRepository;
import com.organization.tara.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getEvents(String period) {

		return null;
	}

	@Override
	public List<Event> getEvents(int page, int size) {
		
		Page<Event> events = eventRepository.findAll(PageRequest.of(page, size));;

		return null;
	}

	@Override
	public List<Event> getEvents(Date fromDate, Date toDate, int page, int size) {
		// TODO Auto-generated method stub
		eventRepository.getEvents(fromDate, toDate, PageRequest.of(page, size));
		return null;
	}

	@Override
	public Event getEvent(int eventId) {
		return eventRepository.getOne(eventId);
	}

	@Override
	public List<Event> getEvents() {

		return eventRepository.findAll();
	}

	@Override
	public List<Event> getEvents(Date fromDate, Date toDate) {
		
		return eventRepository.getEvents(fromDate, toDate);
	}

}
