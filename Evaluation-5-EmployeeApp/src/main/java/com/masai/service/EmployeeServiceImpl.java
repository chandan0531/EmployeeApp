package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeNotFound;
import com.masai.model.Address;
import com.masai.model.Employee;
import com.masai.repositry.AddressDao;
import com.masai.repositry.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	private EmployeeDao eDao;
	
	@Autowired
	private AddressDao aDao;

	@Override
	public Employee createEmployee(Employee emp) throws EmployeeNotFound {
		
		
		 Optional<Employee> opt  = eDao.findById(emp.getEmpId());
		  if(opt.isPresent())
		  {
			  throw new EmployeeNotFound("Employee already present");
		  }
		  else
		  {
//			  eDao.save(emp);
			  System.out.println(emp + "hello");
			  System.out.println(emp.getAdds() + "hello");
			  
			  List<Address> adds= emp.getAdds();//[]
			  System.out.println(adds + "hello"); //[]
			  for(Address add: adds)
			  {
				  add.setEmps(emp);
				  aDao.save(add);
				  
			  }
//////			  
////			  Address address  =new Address(10, "fff", "ggg", "kkk", "ffgf", emp);
////			  aDao.save(address);
//			  
//			  
//			  eDao.save(emp);
//			  return emp;
			  
			
			  return eDao.save(emp);
			  
		  }
	}		  

	@Override
	public List<Employee> getAllEmployee() throws EmployeeNotFound {
		
		List<Employee> emps = eDao.findAll();
		
		if(emps.size() > 0)
		{
			return emps;
		}
		else
		{
			throw new EmployeeNotFound("Employee Not present");
		}

	}

	@Override
	public Employee getEmployeeById(Integer Id) throws EmployeeNotFound {
	
		 Optional<Employee> opt  = eDao.findById(Id);
		
		 if(opt.isPresent())
		 {
			 return opt.get();
		 }
		
		 else
		 {
			 throw new EmployeeNotFound("Employee Not present with: " + Id); 
		 }
	}

	@Override
	public Employee updateEmployeeById(Employee emp, Integer Id) throws EmployeeNotFound {
		
		 Optional<Employee> opt  = eDao.findById(Id);
		
		 if(opt.isPresent())
		 {
			 eDao.save(emp);
			 return emp;
		 }
		
		 else
		 {
			 throw new EmployeeNotFound("Employee Not present with: " + Id);  
		 }
	}

	@Override
	public String deleteEmployeeById(Integer Id) throws EmployeeNotFound {
		
		
		Optional<Employee> opt  = eDao.findById(Id);
		
		if(opt.isPresent())
		{
			Employee emp = opt.get();
			eDao.delete(emp);
			return "Employee details have been deleted with :  + Id";
		}
		else
		{
			throw new EmployeeNotFound("Employee Not present with: " + Id);  
		}
	}
	
	
}
