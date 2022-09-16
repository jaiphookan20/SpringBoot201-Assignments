package com.masai;
// External Entity
public class Demo {
	public static void main(String[] args) {
		// 1. setter
		// Travel objTravel = new Travel();
		// objTravel.setV(new Bike());
		// 2. constructor 
		Travel objTravel = new Travel(new Bike());
		objTravel.journey();
	}
}
