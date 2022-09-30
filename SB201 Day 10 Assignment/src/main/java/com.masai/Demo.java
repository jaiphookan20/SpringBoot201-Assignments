package com.masai;

import java.util.Map;

public class Demo {

	
	private Map<Department, Employee> theMap;
	
	
	//use setter injection to inject theMap;
	
	
	public void myInit(){
	System.out.println("inside myInit method");
	}
	
	
	

	public void cleanUp(){
	System.out.println("inside cleanUp method");
	
	}




	public Map<Department, Employee> getTheMap() {
		return theMap;
	}


	public void setTheMap(Map<Department, Employee> theMap) {
		this.theMap = theMap;
	}


	
	public void showDetails(){
		System.out.println("inside showDetails of Demo class");
		for (Department name:theMap.keySet()) {
		    Department key = name;
		   Employee value = theMap.get(name);
		    System.out.println(key + " " + value);
		}
		
		
		
		
		//print all the details of all the employees department-wise.
		}

}
