package ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;


import utility.EmployeeUtility;

public class Main2 {

	public static void main(String[] args) {
		
		/* ● Inside the main method of Demo2 class get all the students enrolled in a particular course */
		
		EntityManager em = EmployeeUtility.ProvideConnection();
				
		List<Student> studentList = em.find(Course.class, 2).getStudent();
		
		System.out.println(studentList);
		
		
		/* 
		 * [Student [roll=1, name=abbas, email=dfsjhf@gmail.com, mobile=86767], Student [roll=3, name=jay, email=sadksjhf@gmail.com, mobile=867236767]] 		 * 
		 */
		
	}

}
