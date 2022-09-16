package com.masai;

// DEPENDENT CLASS
public class Travel {
	private Vehicle v;
	// Injection Point
		// 1. setter
		// 2. constructor
	
	// 1. setter
	public void setV(Vehicle v) {
		this.v = v;
	}
	// 2. constructor
	public Travel(Vehicle v) {
		super();
		this.v = v;
	}
	public void journey() {
		v.go();
		System.out.println("Journey Started...");
	}
	
}
