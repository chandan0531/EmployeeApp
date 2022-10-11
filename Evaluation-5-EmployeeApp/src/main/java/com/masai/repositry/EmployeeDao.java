package com.masai.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
