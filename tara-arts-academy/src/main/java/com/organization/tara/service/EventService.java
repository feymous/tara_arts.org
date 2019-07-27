package com.organization.tara.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.organization.tara.entities.Event;
import com.organization.tara.visualobjects.EventVO;
import com.organization.tara.visualobjects.GetEventVideoVO;
import com.organization.tara.visualobjects.PutEventVideo;
import com.organization.tara.visualobjects.UpdateEventVideoResponseVO;

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

	List<UpdateEventVideoResponseVO> updateEventVideos(List<PutEventVideo> eventVideos, int eventId);

	List<GetEventVideoVO> getEventVideos(int page, int size, int eventId);

	String getEventImages(int page, int size, int eventId);

}
