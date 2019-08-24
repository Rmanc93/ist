package com.ssw.ist.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "user", method=RequestMethod.GET)
	public Employee getUserByUserName(@RequestParam("name") String name) {
		return userService.findByUsername(name);
	}

}
