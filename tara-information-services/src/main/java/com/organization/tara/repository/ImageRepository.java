package com.organization.tara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.tara.entities.Image;

public interface ImageRepository  extends JpaRepository<Image, Integer> {

}