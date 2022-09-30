package com.masai;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {

	
	void start() {
		System.out.println("bike journey started");
	}

	public void go() {
		// TODO Auto-generated method stub
		start();
		
	}
}
