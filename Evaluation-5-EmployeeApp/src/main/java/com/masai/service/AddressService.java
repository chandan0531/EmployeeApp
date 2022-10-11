package com.masai.service;

import java.util.List;

import com.masai.exception.AddressNotFound;
import com.masai.model.Address;

public interface AddressService {

	
	
	public String createAddressById(Address add,Integer Id) throws AddressNotFound;
	public List<Address> getAllAddressByEmployeeId(Integer Id) throws AddressNotFound;
	public Address getAddressByAddressId(Integer empId ,Integer addId) throws AddressNotFound;
	public Address updateAddressById(Integer empId ,Address add,Integer Id) throws AddressNotFound; 
    public String deleteAddressById(Integer empId ,Integer Id) throws AddressNotFound;
}
