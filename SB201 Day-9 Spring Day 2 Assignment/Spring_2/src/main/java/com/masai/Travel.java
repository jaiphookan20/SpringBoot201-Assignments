package com.masai;

// DEPENDENT CLASS
public class Travel {
	// Object Type Dependency
	private Vehicle v;
	// Injection Point
		// 1. setter
		// 2. constructor
	// Simple Type Dependency
	private int numberOfPerson;
	
	// 1. setter injection -> Object
	public void setV(Vehicle v) {
		this.v = v;
	}
	// 1. setter injection -> Normal
	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	// 2. constructor
//	public Travel(Vehicle v) {
//		super();
//		this.v = v;
//	}
	public Travel(Vehicle v, int numberOfPerson) {
		super();
		this.v = v;
		this.numberOfPerson = numberOfPerson;
	}
	public void journey() {
		v.go();
		System.out.println("NoOfPerson : "+numberOfPerson);
		System.out.println("Journey Started...");
	}
	
}
