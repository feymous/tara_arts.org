package com.organization.tara.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.organization.tara.entities.Event;
import com.organization.tara.entities.Image;
import com.organization.tara.entities.Video;
import com.organization.tara.repository.EventRepository;
import com.organization.tara.repository.ImageRepository;
import com.organization.tara.repository.VideoRepository;
import com.organization.tara.service.EventService;
import com.organization.tara.visualobjects.EventVO;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private VideoRepository videoRepository;

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

		Event event = new Event();
		event.setName(eventVO.getEventName());
		event.setDescription(eventVO.getDescription());
		event.setBroucher(createImage(eventVO.getBroucherUrl(), "BroucherImage", null));
		event.setEndTime(eventVO.getEndTime());
		event.setGuidelines(eventVO.getGuidelines());
		event.setRegistrationOpen(eventVO.isRegistrationOpen());
		event.setStartTime(eventVO.getStartTime());
		event.setVenue(eventVO.getVenue());

		return eventRepository.save(event);
	}

	private Image createImage(String url, String imageType, Event event) {
		Image image = new Image();
		image.setType(imageType);
		image.setUploadedDate(new Date());
		image.setUrl(url);
		image.setEvent(event);
		return imageRepository.save(image);
	}
	private Video createVideo(String url, String videoType, Event event) {
		Video video = new Video();
		video.setType(videoType);
		video.setUploadedDate(new Date());
		video.setUrl(url);
		video.setEvent(event);
		return videoRepository.save(video);
	}
	@Override
	public String updateEventImages(List<String> eventImageUrls, int eventId) {

		Event event = eventRepository.getOne(eventId);
		if (event == null)
			return "Event:" + eventId + "doest exists";
		for (String url : eventImageUrls) {
			createImage(url, "EventImage", event);
		}

		return eventImageUrls.size()+" images added successfully";
	}

	@Override
	public String updateEventVideos(List<String> eventVideoUrls, int eventId) {
		// TODO Auto-generated method stub
		Event event = eventRepository.getOne(eventId);
		if (event == null)
			return "Event:" + eventId + "doest exists";
		for (String url : eventVideoUrls) {
			createVideo(url, "EventVideo", event);
		}
		return eventVideoUrls.size()+" videos added successfully";
	}

}
