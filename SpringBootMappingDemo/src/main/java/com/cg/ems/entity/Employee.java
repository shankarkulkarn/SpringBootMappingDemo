package com.cg.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee_tbl")
public class Employee {

	@Id
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="employee_seq",allocationSize=1)
	@Column(name="empid")
	private int employeeId;
	
	@Column(name="ename",length=15)
	private String employeeName;
	
	@Column(name="esal")
	private double salary;
	
	@ManyToOne
	@JoinColumn(name="deptid")
	private Department  department;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
}
