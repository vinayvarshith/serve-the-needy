package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.NgoMember;

public interface NgoMemberService {

	public NgoMember createNgoMember(NgoMember ngoMember);

	public List<NgoMember> getMembers();

	public NgoMember updateMember(NgoMember ngomember);

	public void deleteMember(int memberId);

	public Optional<NgoMember> getMemberById(int memberId);

}
