package com.saib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saib.model.ConsentModel;

@Repository
public interface ConsentRepo extends CrudRepository<ConsentModel, Long>  {

}
