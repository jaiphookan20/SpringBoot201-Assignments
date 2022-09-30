package com.masai;

import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

	
	
	void start() {
		System.out.println("car journey started");
	}
	public void go() {
		// TODO Auto-generated method stub
		start();
		
	}
	
}
