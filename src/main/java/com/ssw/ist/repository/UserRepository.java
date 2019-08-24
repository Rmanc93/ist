package com.ssw.ist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssw.ist.model.Employee;



@Repository()
public interface UserRepository extends CrudRepository<Employee, Integer> {
	
	public List<Employee> getOneByUsername(String name);

}
