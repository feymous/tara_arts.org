package com.organization.tara.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.tara.entities.Event;
import com.organization.tara.service.EventService;
import com.organization.tara.visualobjects.EventVO;
import com.organization.tara.visualobjects.GetEventVideoVO;
import com.organization.tara.visualobjects.PutEventVideo;
import com.organization.tara.visualobjects.UpdateEventVideoResponseVO;

@RestController
@RequestMapping("event")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping(path = "/") // Map ONLY GET Requests
	public @ResponseBody List<Event> getEvents(@RequestParam(required = false) String period,
			@RequestParam(required = false) Integer size, @RequestParam(required = false) Integer page,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date toDate) {
		List<Event> events = new ArrayList<>();

		if (period != null && (size != null && page != null && size != 0 && page >= 0)) {
			events = eventService.getEvents(period, page, size);
		} else if (period != null) {
			events = eventService.getEvents(period);
		} else if (fromDate != null && (size != null && page != null && size != 0 && page >= 0)) {
			events = eventService.getEvents(fromDate, toDate, page, size);
		} else if (fromDate != null) {
			events = eventService.getEvents(fromDate, toDate);
		} else if (size != null && page != null && size != 0 && page >= 0) {
			events = eventService.getEvents(page, size);
		} else {
			events = eventService.getEvents();
		}

		return events;
	}

	@GetMapping(path = "/{eventId}")
	public @ResponseBody Event getEvent(@PathVariable(required = true) int eventId) {
		return eventService.getEvent(eventId);
	}

	@PostMapping(path = "/")
	public @ResponseBody Event createEvent(@RequestBody EventVO eventVO) {
		return eventService.createEvent(eventVO);
	}

	@PutMapping(path = "/{eventId}/images")
	public @ResponseBody String updateEventImages(@RequestBody List<String> eventImageUrls,
			@PathVariable(required = true) int eventId) {
		return eventService.updateEventImages(eventImageUrls, eventId);
	}

	@PutMapping(path = "/{eventId}/videos")
	public @ResponseBody List<UpdateEventVideoResponseVO> updateEventVideos(
			@RequestBody List<PutEventVideo> eventVideos, @PathVariable(required = true) int eventId) {
		return eventService.updateEventVideos(eventVideos, eventId);
	}

	@GetMapping(path = "/{eventId}/videos")
	public @ResponseBody List<GetEventVideoVO> getEventVideos(@RequestParam(required = false) Integer size,
			@RequestParam(required = false) Integer page, @PathVariable(required = true) int eventId) {
		return eventService.getEventVideos(page, size, eventId);
	}

	@GetMapping(path = "/{eventId}/images")
	public @ResponseBody String getEventImages(@RequestParam(required = false) int size,
			@RequestParam(required = false) Integer page, @PathVariable(required = true) Integer eventId) {
		return eventService.getEventImages(page, size, eventId);
	}
}
