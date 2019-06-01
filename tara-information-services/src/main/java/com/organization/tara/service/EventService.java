package com.organization.tara.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.tara.entities.Event;
import com.organization.tara.visualobjects.EventVO;

@Service
public interface EventService {

	List<Event> getEvents(String period);

	List<Event> getEvents(int page, int size);

	List<Event> getEvents(Date fromDate, Date toDate);

	Event getEvent(int eventId);

	List<Event> getEvents();

	List<Event> getEvents(Date fromDate, Date toDate, int page, int size);

	List<Event> getEvents(String period, int page, int size);

	Event createEvent(EventVO eventVO);

	String updateEventImages(List<String> eventImageUrls, int eventId);

	String updateEventVideos(List<String> eventVideoUrls, int eventId);

}
