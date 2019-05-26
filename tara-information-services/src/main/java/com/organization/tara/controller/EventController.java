package com.organization.tara.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.tara.entities.Event;
import com.organization.tara.service.EventService;

@RestController
@RequestMapping("event")
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping(path = "/") // Map ONLY GET Requests
	public @ResponseBody List<Event> getEvents( @RequestParam String period,
			@RequestParam int limit, @RequestParam int skip, @RequestParam Date fromDate, @RequestParam Date toDate) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		List<Event> events = new ArrayList<>();

		if (limit != 0 && skip >= 0) {
			events = eventService.getEvents(limit, skip);
		} else if (period != null) {
			events = eventService.getEvents(period);
		} else if (fromDate != null) {
			events = eventService.getEvents(fromDate, toDate);
		} else {
			events = eventService.getEvents();
		}

		return events;
	}
	
	@GetMapping(path = "/{eventId}") // Map ONLY GET Requests
	public @ResponseBody Event getEvent(@PathVariable(required = true) int eventId) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		

		return eventService.getEvent(eventId);
	}
}
