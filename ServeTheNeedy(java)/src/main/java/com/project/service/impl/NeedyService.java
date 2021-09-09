package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Donation;
import com.project.model.Needy;
import com.project.model.Request;
import com.project.repository.AddRepository;
import com.project.repository.NeedyRepository;

@Service
public class NeedyService  {

	@Autowired
	private NeedyRepository needyrepository;
	
	@Autowired
	private AddRepository addrepository;
	
	public List<Donation> getDonations(){
	return (List<Donation>) 	needyrepository.findAll();
		
		
	}
	
	public void deleteDonation(Integer dId) {
		needyrepository.deleteById(dId);
	}
	
	public Request addrequest(Request request) {
		return addrepository.save(request);
		
	}
	
	public List<Request> getRequest(){
		return (List<Request>) 	addrepository.findAll();
			
			
		}
	
}
