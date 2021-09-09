package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Donation;
import com.project.model.User;
import com.project.service.DonationService;

@RestController
public class DonatorController {

	private DonationService dsi;

	@Autowired
	public DonatorController(DonationService dsi) {
		super();
		this.dsi = dsi;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/donation", method = RequestMethod.POST)
	public Donation createDonation(@RequestBody Donation donation) {
		return dsi.createDonation(donation);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/donations", method = RequestMethod.GET)
	public List<Donation> getDonation() {
		return dsi.getDonations();
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/donation/{dId}", method = RequestMethod.GET)
	public Donation getDonationById(@PathVariable("dId") int dId) {
		Optional<Donation> donation = dsi.getDonationById(dId);
		return donation.get();
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/donation/update", method = RequestMethod.PUT)
	public Donation updateDonation(@RequestBody Donation donation) {
		return dsi.updateDonation(donation);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/donation/delete/{dId}", method = RequestMethod.DELETE)
	public String deleteDonation(@PathVariable("dId") int dId) {
		dsi.deleteDonation(dId);
		if (dsi.getDonationById(dId).isPresent()) {
			return "The donation is not deleted";

		}
		return "The donation details got deleted";
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return dsi.createUser(user);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User validateDonator(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPassword = user.getPassword();
		// System.out.println(tempEmail+" "+tempPassword);
		User u = null;
		if (tempEmail != null && tempPassword != null)
			u = dsi.fetchUserByemailAndPassword(tempEmail, tempPassword);

		if (u == null)
			throw new Exception("Bad Credential");
		else
			System.out.println("login Succesfull");
		return u;

		// System.out.println(u.get().getPassword()==user.getPassword());

	}

}
