package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeNotFound;
import com.masai.model.Employee;

public interface EmployeeService {

	
	
	public Employee createEmployee(Employee emp)throws EmployeeNotFound;
	
	public List<Employee> getAllEmployee()throws EmployeeNotFound;
	
	public Employee getEmployeeById(Integer Id) throws EmployeeNotFound;
	
	public Employee updateEmployeeById(Employee emp ,Integer Id) throws EmployeeNotFound;
	
    public String deleteEmployeeById(Integer Id) throws EmployeeNotFound;
   
	
}
