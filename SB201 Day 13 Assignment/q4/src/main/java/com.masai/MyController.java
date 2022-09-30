package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@RequestMapping("/emp")
	public Employee sendEmp() {
		Employee em=new Employee(1,"abbas","jamnagar",56570);
		return em;
	}
	@RequestMapping("/helo")
	public  String ss() {
		return "Welcome to Spring Boot";
	}
	
	@RequestMapping("/le")
	public List<Employee> sendEmpList() {
		Employee em1=new Employee(1,"abba","jamnagar",56570);
		Employee em2=new Employee(2,"abbs","jamnagar",56570);
		Employee em3=new Employee(3,"abas","jamnagar",56570);
		Employee em4=new Employee(4,"bas","jamnagar",56570);
		Employee em5=new Employee(5,"bbas","jamnagar",56570);
		List<Employee> le=new ArrayList<>();
		
		le.add(em1);
		le.add(em2);
		le.add(em3);
		le.add(em4);
		le.add(em5);
		
		return le;
		
		
	}

}

