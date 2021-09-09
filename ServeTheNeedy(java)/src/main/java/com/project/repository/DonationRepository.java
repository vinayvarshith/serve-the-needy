package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Donation;
@Repository
public interface DonationRepository 
extends JpaRepository<Donation, Integer> {
	//28 methods
}
