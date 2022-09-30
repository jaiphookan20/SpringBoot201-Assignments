package com.masai;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Travel {
	
	void journey() {
		
		v.go();
		System.out.println("Journey on midway");
	}
	
	
	@Autowired
	@Qualifier("vv")
	private Vehicle v;
	
	
	
	@PostConstruct
	void construct() {
		System.out.println("journey started");
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("journey ended");
	}
	

	
	

}
