package com.daham;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.daham.model.Employee;

public class Main {
	 static List<Employee> employees = new ArrayList<>();
	 static {
		 employees.add(
				new Employee("Daham", "Mustafa", 2000.00, List.of("Project 1","Project 2")));
//				 .firstName("Daham")
//				 .lastName("Mustafa")
//				 .salary(2000.00)
//				 .projects( List.of("Project 1","Project 2"))
//				 .build() );
		 employees.add(
				 new Employee("Swara", "Muhammed", 3000.00, List.of("Project 1","Project 2")));
//				 Employee
//				 .builder()
//				 .firstName("Swara")
//				 .lastName("Muahamed")
//				 .salary(4000.00)
//				 .projects( List.of("Project 1","Project 3"))
//				 .build() );
		 employees.add(
				 new Employee("Shkar", "Ali", 6000.00, List.of("Project 3","Project 4")));
//				 Employee
//				 .builder()
//				 .firstName("Shkar")
//				 .lastName("Ali")
//				 .salary(2000.00)
//				 .projects( List.of("Project 3","Project 4"))
//				 .build() );
	 }
	 
	 

	public static void main(String[] args) {
		//foreach
		employees.stream()
		.forEach(System.out::println);
		
		// map
		Set<Employee> incresedSal = employees.stream()
        .map(employee -> new Employee(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary()  * 1.10,
                employee.getProjects()
        ))
        .collect(Collectors.toSet());
	     System.out.println(incresedSal);
	     
	   // filter
	     
	   List<Employee> filterEmployees=  employees
	             .stream()
	             .filter(employee-> employee.getSalary()> 5000)
	             .map(employee-> new Employee(
	            		 employee.getFirstName(), 
                         employee.getLastName(), 
                         employee.getSalary()*10.10, 
                         employee.getProjects())).collect(Collectors.toList());
	   System.out.println(filterEmployees);
	   
	   // find first
	   Employee firstEmployee=  employees
	             .stream()
	             .filter(employee-> employee.getSalary()> 5000)
	             .map(employee-> new Employee(
	            		 employee.getFirstName(), 
                       employee.getLastName(), 
                       employee.getSalary()*10.10, 
                       employee.getProjects()))
	             .findFirst().orElse(null);
	           
	   System.out.println(firstEmployee);
	   

	}

}