package ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;


import utility.EmployeeUtility;

public class Main3 {

	public static void main(String[] args) {
		
		/* ● Inside the main method of Demo3 class get all the courses in which a particular student has enrolled. */
		
		EntityManager em = EmployeeUtility.ProvideConnection();
		
		List<Course> courseList = em.find(Student.class, 1).getCourse();
		
		System.out.println(courseList);
		
		 
		/*
		[Course [courseId=2, courseName=Java Backend, duration=2 month, fee=3200], Course [courseId=4, courseName=javascript, duration=2 month, fee=3200]]
		*/

	}

}
