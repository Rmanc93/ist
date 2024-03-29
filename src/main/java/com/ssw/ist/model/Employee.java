package com.ssw.ist.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "tbl_employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "sur_name", nullable = false, length = 200)
	private String sName;

	@Column(name = "name", length = 200)
	private String name;

	@Column(name = "actvt_strt_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date actStarDate = new Date();

	@Column(name = "actvt_end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date actEndDate;

	@Column(name = "username", nullable = false, unique = true, length = 200)
	private String username;

	@Column(name = "password", nullable = false, length = 200)
	private String password;


	@OneToOne(fetch = FetchType.EAGER)
	private Role role;

	@OneToOne(fetch = FetchType.EAGER)
	private TaskCatalog task;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonSetter
	public void setPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.password = passwordEncoder.encode(password);
	}



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getActStarDate() {
		return actStarDate;
	}

	public void setActStarDate(Date actStarDate) {
		this.actStarDate = actStarDate;
	}

	public Date getActEndDate() {
		return actEndDate;
	}

	public void setActEndDate(Date actEndDate) {
		this.actEndDate = actEndDate;
	}

	public TaskCatalog getTask() {
		return task;
	}

	public void setTask(TaskCatalog task) {
		this.task = task;
	}

}
