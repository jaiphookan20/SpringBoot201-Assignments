package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Demo d=ctx.getBean("dd",Demo.class);
//             d.showDetails();
		Demo e=ctx.getBean("dd",Demo.class);
		
		e.showDetails();
             
             ClassPathXmlApplicationContext ctx2= (ClassPathXmlApplicationContext) ctx;  
             ctx2.close();
	}

}
