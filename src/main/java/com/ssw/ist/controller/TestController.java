package com.ssw.ist.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.ist.model.Employee;
import com.ssw.ist.model.Stamp;
import com.ssw.ist.repository.StampRepository;
import com.ssw.ist.repository.UserRepository;

@RestController
@RequestMapping(value = "api/")
public class TestController {

	private final String ADMIN = "ROLE_ADMIN";
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	StampRepository stmpRepo;
	
	@Secured({ADMIN})
	@RequestMapping(value = "hello1", method = RequestMethod.GET)
	public Optional<Employee> hello() {
		
		
		Optional<Employee> user= userRepo.findById(1);
		return user;
	}

	
	@RequestMapping(value = "hello",method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	public String greetings(@RequestParam("name") String name, Principal principal) throws ParseException {
		
		
		Date date1 = new SimpleDateFormat( "yyyyMMdd" ).parse( "20190816" );
		Date date2 = new SimpleDateFormat( "yyyyMMdd" ).parse( "20190818" );
		
	
		
		
		
		return new String(name + " (" + principal.getName() + ")");
	}
	
	

}
