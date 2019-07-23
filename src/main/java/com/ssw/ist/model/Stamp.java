package com.ssw.ist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_stamp")
public class Stamp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	private Employee employee;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	private StampCatalog stampCatalog;
	
	@Column(name="mobile_datetime", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date moblieDatetime;
	
	@Column(name = "Server_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date serverDate = new Date();
	

	@OneToOne(fetch = FetchType.EAGER)
	private Employee SuperEmp;
	
	@Column(name = "start_date", nullable= false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Column(name = "end_date", nullable= false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public StampCatalog getStampCatalog() {
		return stampCatalog;
	}

	public void setStampCatalog(StampCatalog stampCatalog) {
		this.stampCatalog = stampCatalog;
	}

	public Date getMoblieDatetime() {
		return moblieDatetime;
	}

	public void setMoblieDatetime(Date moblieDatetime) {
		this.moblieDatetime = moblieDatetime;
	}

	public Date getServerDate() {
		return serverDate;
	}

	public void setServerDate(Date serverDate) {
		this.serverDate = serverDate;
	}

	public Employee getSuperEmp() {
		return SuperEmp;
	}

	public void setSuperEmp(Employee superEmp) {
		SuperEmp = superEmp;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
