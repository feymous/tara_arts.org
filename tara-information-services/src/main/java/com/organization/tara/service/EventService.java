package com.organization.tara.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.tara.entities.Event;

@Service
public interface EventService {

	List<Event> getEvents(String period);

	List<Event> getEvents(int page, int size);

	List<Event> getEvents(Date fromDate, Date toDate);

	Event getEvent(int eventId);

	List<Event> getEvents();

	List<Event> getEvents(Date fromDate, Date toDate, int page, int size);

}
