package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empId;
	
	@NotNull(message = "comment should not be null")
	private String firstName;
	
	@NotNull(message = "comment should not be null")
	private String lastName;
	
	@Size(min=10,max=10)
	private String cellPhone;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "emps")
//	@JsonIgnore
	private List<Address> adds = new ArrayList<>();
//	
	
}
