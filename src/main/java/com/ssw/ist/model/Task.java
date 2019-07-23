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
@Table(name="tbl_task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@OneToOne(fetch = FetchType.EAGER)
	private Employee employee;
	
	@Column(name="catalog_job_number")
	private int ctlgJobNmbr;
	
	@Column(name="start_date",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date strtDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate=null;

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

	public int getCtlgJobNmbr() {
		return ctlgJobNmbr;
	}

	public void setCtlgJobNmbr(int ctlgJobNmbr) {
		this.ctlgJobNmbr = ctlgJobNmbr;
	}

	public Date getStrtDate() {
		return strtDate;
	}

	public void setStrtDate(Date strtDate) {
		this.strtDate = strtDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
