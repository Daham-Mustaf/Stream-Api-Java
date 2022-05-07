package com.daham;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.daham.model.Employee;

public class Main {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Main.class);
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
		log.info(incresedSal.toString());
//	     System.out.println(incresedSal);
	     
	   // filter
	     
	   List<Employee> filterEmployees=  employees
	             .stream()
	             .filter(employee-> employee.getSalary()> 5000)
	             .map(employee-> new Employee(
	            		 employee.getFirstName(), 
                         employee.getLastName(), 
                         employee.getSalary()*10.10, 
                         employee.getProjects())).collect(Collectors.toList());
	   log.info(filterEmployees.toString());
	   
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
	   log.info(firstEmployee.toString());
	   
	   
	   // flat map
	  String projects = employees
	   .stream()
	   .map(employee-> employee.getProjects())
	   .flatMap(strings->strings.stream())
	   .collect(Collectors.joining(","));
	  log.info("[ " + projects + " ]");
	  
	  // Finite Data 
	  Stream.generate(Math::random)
	  .limit(5)
	  .forEach(s->System.out.println(s));
	  
	  
	  // Sort
	 List<Employee> sortedFirstNamEmployees= employees
	  .stream()
	  .sorted(( o1, o2)-> o1.getFirstName().compareTo(o2.getFirstName()))
	  .collect(Collectors.toList());
	  
	 log.info(sortedFirstNamEmployees.toString());  

	}

}
