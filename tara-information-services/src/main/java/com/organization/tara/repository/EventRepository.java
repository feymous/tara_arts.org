package com.organization.tara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.tara.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
