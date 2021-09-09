package com.project.dao;

import com.project.model.NgoMember;

public interface LoginDao {

	public NgoMember loginMember(int memberId, long aadhar);

}
