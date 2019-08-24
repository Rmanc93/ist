package com.ssw.ist.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssw.ist.model.Employee;
import com.ssw.ist.model.Stamp;
import com.ssw.ist.repository.StampRepository;

@Service
public class StampService {

	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private StampRepository stampRepo;

	public List<Stamp> getStampByEmployeeId(int id) {
		return stampRepo.findByEmployeeId(id);
	}

	public List<Stamp> findByServerDateGreaterThanEqual(Date serverDate, int opt) throws ParseException {
		Date date3 = formatter.parse(formatter.format(serverDate));
		switch (opt) {

		case 1:
			date3.setTime(date3.getTime() - (24L * 60 * 60 * 1000));
			break;
		case 2:
			date3.setTime(date3.getTime() - (7L * 24L * 60 * 60 * 1000));
			break;
		case 3:
			date3.setMonth(date3.getMonth() - 1);
			break;
		case 4:
			date3.setYear(date3.getYear() - 1);
			break;

		default:
			break;
		}

		return stampRepo.findByServerDateGreaterThanEqual(date3);
	}

	public List<Stamp> findByServerDateBetween(Date serverDate1, Date serverDate2) throws ParseException {
		Date date3 = formatter.parse(formatter.format(serverDate1));
		Date date4 = formatter.parse(formatter.format(serverDate2));
		date4.setTime(date4.getTime() + (24 * 60 * 60 * 1000));
		return stampRepo.findByServerDateBetween(date3, date4);
	}

	public List<Stamp> findByEmployeeUsernameAndServerDateBetween(String username, Date serverDate1, Date serverDate2)
			throws ParseException {
		Date date3 = formatter.parse(formatter.format(serverDate1));
		Date date4 = formatter.parse(formatter.format(serverDate2));
		date4.setTime(date4.getTime() + (24 * 60 * 60 * 1000));
		return stampRepo.findByEmployeeUsernameAndServerDateBetween(username, date3, date4);
	}

	public List<Stamp> findByEmployeeUsernameAndServerDateGreaterThanEqual(String username, Date serverDate, int opt)
			throws ParseException {
		Date date3 = formatter.parse(formatter.format(serverDate));
		switch (opt) {

		case 1:
			date3.setTime(date3.getTime() - (24L * 60 * 60 * 1000));
			break;
		case 2:
			date3.setTime(date3.getTime() - (7L * 24L * 60 * 60 * 1000));
			break;
		case 3:
			date3.setMonth(date3.getMonth() - 1);
			break;
		case 4:
			date3.setYear(date3.getYear() - 1);
			break;

		default:
			break;
		}
		return stampRepo.findByEmployeeUsernameAndServerDateGreaterThanEqual(username, date3);
	}

}
