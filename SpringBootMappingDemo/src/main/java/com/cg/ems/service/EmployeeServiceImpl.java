package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	  @Autowired
	  EmployeeDao  employeeDao;
	@Override
	public Employee findEmployeeById(int employeeId) throws EmployeeException  {
		
		if( ! employeeDao.existsById(employeeId))
		{
			throw new EmployeeException(" ID NOT FOUND ");
		}
		return employeeDao.findById(employeeId).get();
	}
	@Override
	public Employee createEmployee(Employee employee) {
	 Employee  emp = employeeDao.saveAndFlush(employee);
     return emp;
	}
	@Override
	public List<Employee> findAllEmployees() throws EmployeeException {
        
		List<Employee> list = employeeDao.findAll();
		return list;
	}
	@Override
	public Employee deleteEmployeeById(int employeeId) throws EmployeeException {
Employee  emp =null;
		
		if( employeeDao.existsById(employeeId))
		{
			 emp = employeeDao.findById(employeeId).get();
			 employeeDao.deleteById(employeeId);
		}
		else
		{
			throw new EmployeeException(" ID NOT FOUND ");
		}
		return emp ;
	}
	@Override
	public List<Employee> findByDepartmentId(int departmentId) {
		
		return employeeDao.findByDepartmentId(departmentId);
		
	}
}