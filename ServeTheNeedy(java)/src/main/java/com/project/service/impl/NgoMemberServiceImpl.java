package com.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.NgoMember;
import com.project.repository.NgoMemberRepo;
import com.project.service.NgoMemberService;

@Service
public class NgoMemberServiceImpl implements NgoMemberService {

	private NgoMemberRepo ngoMemberRepo;

	@Autowired
	public NgoMemberServiceImpl(NgoMemberRepo ngoMemberRepo) {
		super();
		this.ngoMemberRepo = ngoMemberRepo;
	}

	@Override
	public NgoMember createNgoMember(NgoMember ngoMember) {
		return ngoMemberRepo.save(ngoMember);
	}

	@Override
	public List<NgoMember> getMembers() {
		return ngoMemberRepo.findAll();
	}

	@Override
	public NgoMember updateMember(NgoMember ngomember) {
		return ngoMemberRepo.save(ngomember);
	}

	@Override
	public void deleteMember(int memberId) {
		ngoMemberRepo.deleteById(memberId);
	}

	@Override
	public Optional<NgoMember> getMemberById(int memberId) {
		return ngoMemberRepo.findById(memberId);
	}

}
