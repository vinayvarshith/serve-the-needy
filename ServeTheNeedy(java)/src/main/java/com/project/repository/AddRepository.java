package com.project.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Request;


@Repository
public interface AddRepository  extends CrudRepository<Request, Integer>{

}
