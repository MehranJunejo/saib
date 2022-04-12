package com.saib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saib.model.Logs;

@Repository
public interface LogsRepo extends CrudRepository<Logs, Long>  {

}
