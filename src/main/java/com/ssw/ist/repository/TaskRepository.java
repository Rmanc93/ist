package com.ssw.ist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssw.ist.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}
