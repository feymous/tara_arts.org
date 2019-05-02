package com.organization.tara.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.organization.tara.entities.Event;

public interface EventRepository extends MongoRepository<Event, Integer>{
	
	    public Event findByEventName(String firstName);
	    public List<Event> findByEventDate(Date evenDatet);

	
}
