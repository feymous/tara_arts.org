package com.organization.tara.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.organization.tara.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	@Query("SELECT e FROM Event AS e where e.startTime >= :fromDate AND e.startTime <= :toDate")
	List<Event> getEvents(@Param(value = "fromDate") Date fromDate,@Param(value = "toDate") Date toDate, Pageable pageable);
	
	@Query("SELECT e FROM Event AS e where e.startTime >= :fromDate AND e.startTime <= :toDate")
	List<Event> getEvents(@Param(value = "fromDate") Date fromDate,@Param(value = "toDate") Date toDate);
	
	@Query("SELECT e FROM Event AS e where e.startTime >= :currDate")
	List<Event> getUpcomingEvents(@Param(value = "currDate") Date currDate);
	
	@Query("SELECT e FROM Event AS e where e.startTime <= :currDate")
	List<Event> getPastEvents(@Param(value = "currDate") Date currDate);
	
	@Query("SELECT e FROM Event AS e where e.startTime >= :currDate")
	List<Event> getUpcomingEvents(@Param(value = "currDate") Date currDate, Pageable pageable);
	
	@Query("SELECT e FROM Event AS e where e.startTime <= :currDate")
	List<Event> getPastEvents(@Param(value = "currDate") Date currDate, Pageable pageable);
}
