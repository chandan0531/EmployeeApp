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

import com.masai.model.Address;
import com.masai.service.AddressServiceImpl;
import com.masai.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees/{empId}/address")

public class AddressController {

	
	@Autowired
	private AddressServiceImpl aService;
	
	@Autowired
	private EmployeeServiceImpl eService;
	
	
	@PostMapping("/")
	ResponseEntity<String> createAddressByEmployeeIdHandeller(@Valid @RequestBody Address add ,
			@PathVariable("empId") Integer Id){
		            
		String message =  aService.createAddressById(add, Id);     
		            
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	ResponseEntity<List<Address>> getAllAddressByEmpIdHandeller(@PathVariable("empId") Integer Id){
		          
		List<Address> adds =  aService.getAllAddressByEmployeeId(Id);    
		            
		return new ResponseEntity<List<Address>>(adds, HttpStatus.ACCEPTED);
	}
	
	
	
	
	@PutMapping("/{Id}")
	ResponseEntity<Address> updateAddressByIdHandeller(@Valid @PathVariable("empId") Integer Id ,@RequestBody Address adds ,@PathVariable("Id") Integer addId){
		             
		Address ad =  aService.updateAddressById(Id, adds, addId);    
		            
		return new ResponseEntity<Address>(ad, HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/{Id}")
	ResponseEntity<Address> getAddresstByIdHndeller(@PathVariable("empId") Integer Id, @PathVariable("Id") Integer  addId){
		
		Address adds =   aService.getAddressByAddressId(Id, addId);
		            
		return new ResponseEntity<Address>(adds, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/{Id}")
	ResponseEntity<String> deleteAddressById(@PathVariable("empId") Integer Id, @PathVariable("Id") Integer addId){
		            String mess =  aService.deleteAddressById(Id, addId);    
		            return new ResponseEntity<String>(mess, HttpStatus.ACCEPTED);
	}
	
}
