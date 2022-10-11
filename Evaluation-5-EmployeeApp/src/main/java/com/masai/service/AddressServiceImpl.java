package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AddressNotFound;
import com.masai.exception.EmployeeNotFound;
import com.masai.model.Address;
import com.masai.model.Employee;
import com.masai.repositry.AddressDao;
import com.masai.repositry.EmployeeDao;

@Service
public class AddressServiceImpl implements AddressService{

	
	@Autowired
	private AddressDao aDao;
	
	@Autowired
	private EmployeeDao eDao;
	
	
	@Override
	public String createAddressById(Address add, Integer Id) throws AddressNotFound {

	    Optional<Employee> opt = eDao.findById(Id);		   
	    if(opt.isEmpty()) {
	    	throw new EmployeeNotFound("Address not found with this given ID" + Id);
	    }

	    opt.get().getAdds().add(add);
	    add.setEmps(opt.get());
	    
	    aDao.save(add);
	    
	    return "Address on the employee successfully...";
	}

	@Override
	public List<Address> getAllAddressByEmployeeId(Integer Id) throws AddressNotFound {
		
		Optional<Employee> opt = eDao.findById(Id);
		 
		 if(opt.isEmpty()) {
			 throw new EmployeeNotFound("Employee not found with this given ID " + Id);
		 }	
		 else
		 {
			 return opt.get().getAdds();
		 }
		
		
	}

	@Override
	public Address getAddressByAddressId(Integer empId, Integer addId) throws AddressNotFound {
		
		Optional<Employee> opt =  eDao.findById(empId);
		
		if(opt.isEmpty()) {
	    	 throw new EmployeeNotFound("Employee not found with this given ID " + empId);
	     }
		  
		Optional<Address> add =  aDao.findById(addId);
		if(add.isEmpty()) {
			throw new AddressNotFound("Address Not Found with this given ID" + addId);
		}
		
       return add.get();
	}

	@Override
	public Address updateAddressById(Integer empId, Address add, Integer Id) throws AddressNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAddressById(Integer empId, Integer Id) throws AddressNotFound {
		
		
		Optional<Employee> opt =  eDao.findById(empId);
		
	     if(opt.isEmpty()) {
	    	 throw new EmployeeNotFound("Employee not found with this given ID" + empId);
	     }
		
		Optional<Address> add =   aDao.findById(Id);
		   if(add.isEmpty()) {
			   throw new AddressNotFound("Address not found with this given ID" + Id);
		   }
		   
		   aDao.deleteById(Id);
		   
		   return "Address deleted successfully...";
	}

}
