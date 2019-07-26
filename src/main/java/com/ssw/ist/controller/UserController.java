package com.ssw.ist.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.ist.model.Employee;
import com.ssw.ist.service.UserService;

@RestController
@RequestMapping(value = "api/")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "owndetails",method = RequestMethod.GET)
	public Employee getOwnDetails(Principal principle) {
		
		return userService.findByUsername(principle.getName());

	}

}
