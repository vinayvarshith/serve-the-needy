package com.project.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Needy;

@Repository
public interface LoginRepository extends JpaRepository<Needy, Integer>{
	
	public Needy findByUsernameAndPassword(String username, String password);

}
