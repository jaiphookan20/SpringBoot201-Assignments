package OneToManyBiDirectional;

import java.util.List;

import javax.persistence.EntityManager;

import utility.EmployeeUtility;

/* 
 * 
 * Note: use mappedBy clause to avoid 3rd linking table generation

● Create a client application to store 2 Collage object and In each collage enroll 4 students object.

● Write a JPQL to get all the Student details based on collageId and print the details.

● Write a JPQL to get the Collage details based on studentRoll and print the details.

 */

public class Demo1 {

	public static void main(String[] args) {
		
		EntityManager em = EmployeeUtility.ProvideConnection();
		
		Collage collegeObj = new Collage();
		collegeObj.setCollageName("UniMelb");
		collegeObj.setCollageAddress("Melbourne");
		
		Student s1 = new Student();
		s1.setStudentName("Jai");
		s1.setMobileNumber("99875");
		s1.setEmail("jai@unimelb.com");
		s1.setCollage(collegeObj);
		
		
		Student s2 = new Student();
		s2.setStudentName("Shaswati");
		s2.setEmail("shas@gmail.com");
		s2.setMobileNumber("99876");
		s2.setCollage(collegeObj);
		
		
		collegeObj.getStudentList().add(s1);
		collegeObj.getStudentList().add(s2);
		
		em.getTransaction().begin();
		
		em.persist(collegeObj);
		
		em.getTransaction().commit();
		
		/*
		● Write a JPQL to get all the Student details based on collageId and print the details
		*/
		
		Collage collageObj = em.find(Collage.class, 1);
		
		List<Student> studentList = collageObj.getStudentList();
		
		studentList.forEach(s -> {
			System.out.println("Student Name: "+ s.getStudentName());
			System.out.println("Student Mobile: "+ s.getMobileNumber());
			System.out.println("Student Email: "+ s.getEmail());
			System.out.println("Student Roll: "+ s.getStudentRoll());
		});
		
		Student studentObj = em.find(Student.class, 1);
		

		System.out.println("Done..... ");
		
//		● Write a JPQL to get the Collage details based on studentRoll and print the details. ? HOW? NOT DONE
	}

}

/* OUTPUT: 

Write a JPQL to get all the Student details based on collageId and print the details

Student Name: Jai
Student Mobile: 99875
Student Email: jai@unimelb.com
Student Roll: 2
Student Name: Shaswati
Student Mobile: 99876
Student Email: shas@gmail.com
Student Roll: 3
Done





*/
