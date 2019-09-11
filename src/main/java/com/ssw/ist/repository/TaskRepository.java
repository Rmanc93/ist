package com.ssw.ist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssw.ist.model.TaskCatalog;



@Repository
public interface TaskRepository extends CrudRepository<TaskCatalog, Integer> {

}
