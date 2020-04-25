package com.cg.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entity.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;

@RestController
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	EmployeeService  employeeService;
	@GetMapping("employee/department/{id}")
	public  ResponseEntity<List<Employee>>  findDepartmentById(@PathVariable("id")  int id) 
	{
		
		   List<Employee>  employees = employeeService.findByDepartmentId(id);
		   ResponseEntity<List<Employee>>  re = new ResponseEntity<>(employees,HttpStatus.OK);
		   return re;
	}
	
	@GetMapping("employee/{id}")
	public  ResponseEntity<Employee>  findEmployeeById(@PathVariable("id")  int id) throws EmployeeException 
	{
		
		   Employee  employee = employeeService.findEmployeeById(id);
		   ResponseEntity<Employee>  re = new ResponseEntity<Employee>(employee,HttpStatus.OK);
		   return re;
	}
	
	@PostMapping("employee")
	public ResponseEntity<Employee>  createEmployee(@RequestBody Employee employee)
	{
		Employee  emp = employeeService.createEmployee(employee);
		ResponseEntity<Employee>  re = new ResponseEntity<Employee>(emp,HttpStatus.OK);
		return re;
	}
	
	
	
	@GetMapping("employee")
	public ResponseEntity<List<Employee>>  findAllEmployees() throws EmployeeException
	{
	  
		List<Employee> list = employeeService.findAllEmployees();
		ResponseEntity<List<Employee>>  rt = new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		return rt;
		
	}
	
	@DeleteMapping("employee/{id}")
	public  ResponseEntity<Employee>  deleteEmployeeById(@PathVariable("id") int employeeId) throws EmployeeException
	{
		
		ResponseEntity<Employee>  rt = null;
		
		
	    Employee employee = employeeService.deleteEmployeeById(employeeId);
		rt= new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
		return rt;
	}
	
}
