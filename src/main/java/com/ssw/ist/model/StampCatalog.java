package com.ssw.ist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_stamp_catalog")
public class StampCatalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "code", length = 10, nullable = false)
	private String code;

	@Column(name = "description", length = 200, nullable = false)
	private String type;

	@Column(name = "sign_stamp", nullable = false)
	private String singType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSingType() {
		return singType;
	}

	public void setSingType(String singType) {
		this.singType = singType;
	}
	
	
}
