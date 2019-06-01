package com.organization.tara.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.organization.tara.entities.Event;
import com.organization.tara.entities.Image;
import com.organization.tara.repository.EventRepository;
import com.organization.tara.repository.ImageRepository;
import com.organization.tara.service.EventService;
import com.organization.tara.visualobjects.EventVO;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private ImageRepository imageRepository;

	@Override
	public List<Event> getEvents(String period) {
		List<Event> eventList = null;
		if ("past".equals(period)) {
			eventList = eventRepository.getPastEvents(new Date());
		} else if ("upcoming".equals(period)) {
			eventList = eventRepository.getUpcomingEvents(new Date());
		}
		return eventList;
	}

	@Override
	public List<Event> getEvents(String period, int page, int size) {
		List<Event> eventList = null;
		if ("past".equals(period)) {
			eventList = eventRepository.getPastEvents(new Date(), PageRequest.of(page, size));
		} else if ("upcoming".equals(period)) {
			eventList = eventRepository.getUpcomingEvents(new Date(), PageRequest.of(page, size));
		}
		return eventList;
	}

	@Override
	public List<Event> getEvents(int page, int size) {

		return eventRepository.findAll(PageRequest.of(page, size)).getContent();

	}

	@Override
	public List<Event> getEvents(Date fromDate, Date toDate, int page, int size) {
		return eventRepository.getEvents(fromDate, toDate, PageRequest.of(page, size));

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

	@Override
	public Event createEvent(EventVO eventVO) {
		// TODO Auto-generated method stub

		Event event = new Event();
		event.setName(eventVO.getEventName());
		event.setDescription(eventVO.getDescription());
		event.setBroucher(getImage(eventVO.getBroucherUrl(), "BroucherImage"));
		event.setEndTime(eventVO.getEndTime());
		event.setGuidelines(eventVO.getGuidelines());
		event.setRegistrationOpen(eventVO.isRegistrationOpen());
		event.setStartTime(eventVO.getStartTime());
		event.setVenue(eventVO.getVenue());
		
		return eventRepository.save(event);
	}

	private Image getImage(String url, String imageType) {
		// TODO Auto-generated method stub
		Image image = new Image();
		image.setType(imageType);
		image.setUploadedDate(new Date());
		image.setUrl(url);
		return imageRepository.save(image);
	}

}
