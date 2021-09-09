package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.NgoMember;

@Repository
public interface NgoMemberRepo extends JpaRepository<NgoMember, Integer> {
}
