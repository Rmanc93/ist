package com.ssw.ist.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.ist.model.Employee;
import com.ssw.ist.repository.UserRepository;

@RestController
@RequestMapping(value = "api/")
public class TestController {

	private final String ADMIN = "ROLE_ADMIN";
	
	@Autowired
	private UserRepository userRepo;
	
	@Secured({ADMIN})
	@RequestMapping(value = "hello1", method = RequestMethod.GET)
	public Employee hello() {
		
		
		Employee user= userRepo.getOne(1);
		return user;
	}

	
	@RequestMapping(value = "hello",method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public String greetings(@RequestParam("name") String name, Principal principal) {
		return new String(name + " (" + principal.getName() + ")");
	}

}
