package com.ssw.ist.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ssw.ist.model.Employee;
import com.ssw.ist.model.Stamp;

@Repository
public interface StampRepository extends CrudRepository<Stamp, Integer> {

	public List<Stamp> findByEmployeeId(@Param("id") int id);

	public List<Stamp> findByServerDateGreaterThanEqual(@Param("serverDate") Date serverDate);
	
	public List<Stamp> findByServerDateBetween(@Param("serverDate1") Date serverDate1,
			@Param("serverDate2") Date serverDate2);

	public List<Stamp> findByEmployeeUsernameAndServerDateBetween(@Param("username") String username, @Param("serverDate1") Date serverDate1,
			@Param("serverDate2") Date serverDate2);

	public List<Stamp> findByEmployeeUsernameAndServerDateGreaterThanEqual(@Param("username") String username, @Param("serverDate") Date serverDate);

	

}
