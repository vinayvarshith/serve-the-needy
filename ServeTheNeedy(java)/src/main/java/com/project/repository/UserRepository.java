package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,String>{
	public User findByEmailAndPassword(String email,String password);
}
