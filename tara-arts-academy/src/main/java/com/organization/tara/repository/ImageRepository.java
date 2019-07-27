package com.organization.tara.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.organization.tara.entities.Image;

public interface ImageRepository  extends JpaRepository<Image, Integer> {

	List<Image> findByVideo(String video);

	@Query("SELECT i FROM Image AS i ORDER BY id DESC")
	List<Image> getCascadeImage(Pageable pageable);

}
