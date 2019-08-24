package com.ssw.ist.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssw.ist.model.Employee;
import com.ssw.ist.model.Stamp;
import com.ssw.ist.service.StampService;

@RestController
@RequestMapping(value = "api/")
public class StampCntroller {

	@Autowired
	private StampService stamService;

	@GetMapping(value = "stampforuser")
	public List<Stamp> getStampByUserId(@RequestParam("id") int id) {
		return stamService.getStampByEmployeeId(id);
	}

	@GetMapping(value = "allstampfordaternge")
	public List<Stamp> findByServerDateBetween(@RequestParam("option") int opt,
			@RequestParam(value = "fromdate", required = false) Date serverDate1,
			@RequestParam(value = "todate", required = false) Date serverDate2) throws ParseException {

		if (serverDate2 == null) {
			
			return stamService.findByServerDateGreaterThanEqual(serverDate1, opt);
		} else {
			return stamService.findByServerDateBetween(serverDate1, serverDate2);
		}


	}

	@GetMapping(value = "userstampfordaterange")
	public List<Stamp> findByEmployeeIdAndServerDateBetween(@RequestParam("username") String username, @RequestParam("option") int opt,
			@RequestParam(value = "fromdate", required = false) Date serverDate1,
			@RequestParam(value = "todate", required = false) Date serverDate2) throws ParseException {
		System.out.println(serverDate1 + " " + serverDate2);

		if (serverDate2 == null) {
			return stamService.findByEmployeeUsernameAndServerDateGreaterThanEqual(username, serverDate1, opt);
		} else {
			return stamService.findByEmployeeUsernameAndServerDateBetween(username, serverDate1, serverDate2);
		}

	}

}
