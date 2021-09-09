package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Donation;
import com.project.model.Request;

@Repository
public interface NeedyRepository extends JpaRepository<Donation, Integer>{

	
}
