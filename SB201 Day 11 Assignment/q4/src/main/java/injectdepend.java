package com.masai;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


@Service
public class injectdepend {
	
	
	@Value("#{'${my.list.of.cities}'.split(',')}") 
	@Autowired
	 private List<String> cities;
	
	
    @Autowired
    @Qualifier("st")
	private  List<Student> students;


	@Override
	public String toString() {
		return "injectdepend [cities=" + cities + ", students=" + students + "]";
	}
    
	@PostConstruct
	void construct() {
		System.out.println("journey started");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("journey ended");
	}
    
	

	
	   
	
	
	

	
	

}
