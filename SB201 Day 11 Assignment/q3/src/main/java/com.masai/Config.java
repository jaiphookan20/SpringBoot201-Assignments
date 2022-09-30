package com.masai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.masai")
public class Config {
	
	@Bean("vv")
	public Vehicle getV(){
	Car c1=new Car();
	return c1;
	}

}
