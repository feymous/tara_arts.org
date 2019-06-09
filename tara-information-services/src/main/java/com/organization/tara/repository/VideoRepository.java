package com.organization.tara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.tara.entities.Event;
import com.organization.tara.entities.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

	List<Video> findByEvent(Event event);

}
