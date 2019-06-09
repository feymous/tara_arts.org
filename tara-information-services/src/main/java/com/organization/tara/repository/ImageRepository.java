package com.organization.tara.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.tara.entities.Image;

public interface ImageRepository  extends JpaRepository<Image, Integer> {

	List<Image> findByVideo(String video);

}
