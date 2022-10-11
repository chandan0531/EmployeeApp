package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Address {
	
	@Id
	private Integer addId;
	
	@Size(min = 2 ,message = "street size must be min 2 ")
	private String street;
	
	@Size(min = 2 ,message = "city size must be min 2 ")
	private String city;
	
	@Size(min = 2 ,message = "state size must be min 2 ")
	private String state;
	
	@Size(min = 2 ,message = "country size must be min 2 ")
	private String country;
	
		
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Employee emps;
}
