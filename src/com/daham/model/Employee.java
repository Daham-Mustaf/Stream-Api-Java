package com.daham.model;

import java.util.List;

import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Employee {
	private String firstName;
	private String lastName;
	private Double salary;
	private List<String> projects;

}
