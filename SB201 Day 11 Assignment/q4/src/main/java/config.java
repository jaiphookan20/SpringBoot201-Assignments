package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages="com.masai")
@PropertySource("a1.properties")
public class Config {
	
	@Bean("vv")
	public Vehicle getV(){
	Car c1=new Car();
	return c1;
	}
	
	@Bean("st")
	public List<Student> getstudents(){
		
		List<Student> students = new ArrayList<Student>();
		
		students.add(new Student(1,"abbas",576));
		students.add(new Student(2,"ab",524));
		students.add(new Student(3,"abb",541));
		students.add(new Student(3,"abba",516));
		
		
		return students;
		}


}
