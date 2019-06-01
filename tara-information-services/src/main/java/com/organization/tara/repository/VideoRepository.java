package com.organization.tara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.tara.entities.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

}
