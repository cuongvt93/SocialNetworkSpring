package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Id
	@Column(name = "DEPT_ID", nullable = false)
	private Long id;

	@Column(name = "DEPT_NAME", nullable = false)
	private String deptName;
	
	@Column(name = "DEPT_NO", nullable = false)
	private String deptNo;
	
	@Column(name = "LOCATION")
	private String location;
	
	public Department() {
		super();
	}

	public Department(Long id, String deptName, String deptNo, String location) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.deptNo = deptNo;
		this.location = location;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
}
