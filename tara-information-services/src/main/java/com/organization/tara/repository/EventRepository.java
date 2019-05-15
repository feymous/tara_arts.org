package com.organization.tara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.tara.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
