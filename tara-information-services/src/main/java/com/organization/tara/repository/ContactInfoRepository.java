package com.organization.tara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.tara.entities.ContactInfo;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Integer>{

}
