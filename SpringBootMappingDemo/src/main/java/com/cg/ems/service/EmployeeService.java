package com.cg.ems.service;

import java.util.List;

import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;

public interface EmployeeService {

	public List<Employee>  findByDepartmentId(int departmentId);
	public Employee findEmployeeById(int employeeId) throws EmployeeException ;
	
	public Employee createEmployee(Employee  employee);
	
	public List<Employee>  findAllEmployees() throws EmployeeException;
	
	public Employee deleteEmployeeById(int employeeId) throws EmployeeException;
}
