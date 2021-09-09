package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.LoginDao;
import com.project.dao.LoginDaoImpl;
import com.project.model.NgoMember;
import com.project.service.NgoMemberService;

@RestController
@RequestMapping("/Ngo")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class NgoMemberController {

	private NgoMemberService memberService;

	@Autowired
	public NgoMemberController(NgoMemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@PostMapping("/NgoMember")
	public ResponseEntity<NgoMember> createNgoMember(@RequestBody NgoMember ngoMember) {
		ResponseEntity<NgoMember> re = new ResponseEntity<>(memberService.createNgoMember(ngoMember),
				HttpStatus.CREATED);
		return re;
	}

	@GetMapping("/NgoMembers")
	public List<NgoMember> getMembers() {
		return memberService.getMembers();
	}

	@GetMapping("/NgoMember/{memberId}")
	public NgoMember getMemberById(@PathVariable("memberId") int memberId) {
		Optional<NgoMember> ngo = memberService.getMemberById(memberId);
		return ngo.get();
	}

	@DeleteMapping(value = "/NgoMember/delete/{memberId}")
	public String deleteMember(@PathVariable("memberId") int memberId) {
		memberService.deleteMember(memberId);
		if (memberService.getMemberById(memberId).isPresent()) {
			return "The Member is not deleted";
		} else
			return "The Member is now deleted";
	}

	@PutMapping("/NgoMember/update/{memberId}")
	public ResponseEntity<NgoMember> updateMember(@PathVariable("memberId")int memberId, @RequestBody NgoMember ngoMember) {
		NgoMember member = memberService.updateMember(ngoMember);
		return new ResponseEntity<>(member, HttpStatus.OK);
	}

	@GetMapping("/{memberId}/{aadhar}")
	public Optional<NgoMember> loginMember(@PathVariable("memberId") int memberId,
			@PathVariable("aadhar") long aadhar) {
		LoginDao dao = new LoginDaoImpl();
		NgoMember member2 = dao.loginMember(memberId, aadhar);
		if (member2 != null) {
			return memberService.getMemberById(memberId);
		} else
			return null;
	}
}
