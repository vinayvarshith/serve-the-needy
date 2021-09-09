package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.NgoMember;

@Repository
public interface NgoMemberDAO extends JpaRepository<NgoMember, Integer> {

}
