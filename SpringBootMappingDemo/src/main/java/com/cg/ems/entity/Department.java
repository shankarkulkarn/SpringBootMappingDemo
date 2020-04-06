package com.cg.ems.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="department_tbl")
public class Department {

	  @Id
	  @GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	  @SequenceGenerator(name="mygen",sequenceName="department_seq",allocationSize=1)
	  @Column(name="deptid")
	  private int departmentId;
	  
	  @Column(name="dname",length=15)
	  private String departmentName;
	  
	  @OneToMany(mappedBy="department")
	  @JsonIgnore
	  List<Employee>  employees = new ArrayList<>();

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	  
	  
}
