package com.ssw.ist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssw.ist.model.Employee;
import com.ssw.ist.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public Employee findByUsername(String name) {
		
		Employee user =userRepo.getOneByUsername(name).get(0);
		return user;
	}

}
