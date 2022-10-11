package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Employee;
import com.masai.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	
	@Autowired
	private EmployeeServiceImpl eService;
	
	
	@PostMapping("/")
	 ResponseEntity<Employee> createEmployeeHandeller(@Valid @RequestBody Employee emp){
	        Employee  emps =  eService.createEmployee(emp);       
	         return new ResponseEntity<>(emps,HttpStatus.CREATED);         
	 }
	
	
	
	
	@GetMapping("/")
	 ResponseEntity<List<Employee>> getAllEmployeesHandeller(){
        List<Employee> emps = eService.getAllEmployee();      
        
        return new ResponseEntity<List<Employee>>(emps,HttpStatus.ACCEPTED);         
    }
	
	
	
	@GetMapping("/{Id}")
	 ResponseEntity<Employee> getEmployeeByIdHandeller(@PathVariable("Id") Integer Id){
		Employee emp =  eService.getEmployeeById(Id);         
        return new ResponseEntity<Employee>(emp,HttpStatus.ACCEPTED);         
    }
	
	
	
	@PutMapping("/{Id}")
	 ResponseEntity<Employee> updateEmployeeByIdHandeller(@RequestBody Employee emp ,@PathVariable Integer Id){
       
		Employee emps =  eService.updateEmployeeById(emp, Id);
        
        return new ResponseEntity<Employee>(emps,HttpStatus.ACCEPTED);         
    }
	
	

	 @DeleteMapping("/{Id}")
	 ResponseEntity<String> deleteAddressByIdHandeller(@PathVariable Integer Id){
		 
		 
        String message =  eService.deleteEmployeeById(Id);
        
        return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);         
    }
}
