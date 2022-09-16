package com.masai;
// POJO Class
// DEPENDENCY CLASS
public class Car implements Vehicle{
	public void start1() {
		System.out.println("Journey Started via car !...");
	}

	public void go() {
		start1();
	}
}
