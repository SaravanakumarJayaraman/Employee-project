package com.employee.project.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name ="departmentname")
	private String departmentName;
	
	@Column(name ="departmentyear")
	private String departmentYear;
	
	public Department() {
		
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", departmentYear=" + departmentYear
				+ "]";
	}

	public Department(long id, String departmentName, String departmentYear) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentYear = departmentYear;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentYear() {
		return departmentYear;
	}

	public void setDepartmentYear(String departmentYear) {
		this.departmentYear = departmentYear;
	}
	
	

}
