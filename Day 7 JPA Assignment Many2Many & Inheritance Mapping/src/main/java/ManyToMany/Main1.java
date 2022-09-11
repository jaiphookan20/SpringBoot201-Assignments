package ManyToMany;

import java.util.List;

import javax.persistence.EntityManager;


import utility.EmployeeUtility;

public class Main1 {

	public static void main(String[] args) {
		
		/*
			Inside the main method of Demo1 class Enroll some students in multiple course and in some
			course multiple students.
		*/
		
		EntityManager em = EmployeeUtility.ProvideConnection();
		
		Student s1 = new Student();
		s1.setName("abbas");
		s1.setMobile("86767");
		s1.setEmail("dfsjhf@gmail.com");
		
		Student s2=new Student();
		s2.setName("jay");
		s2.setMobile("867236767");
		s2.setEmail("sadksjhf@gmail.com");
		
		Course c1 = new Course();
		c1.setCourseName("Java Backend");
		c1.setDuration("2 month");
		c1.setFee(3200);
		
		/* Enrolling Multiple Students in a Course*/
		c1.getStudent().add(s1);
		c1.getStudent().add(s2);
		
		Course c2 = new Course();
		c2.setCourseName("javascript");
		c2.setDuration("2 month");
		c2.setFee(3200);
		
		/* Enrolling Multiple Students in another Course*/
		c2.getStudent().add(s1);
		c2.getStudent().add(s2);
		
		/* Enrolling Students TO Courses*/
		s1.getCourse().add(c1);
		s1.getCourse().add(c2);
		
		s2.getCourse().add(c1);
		s2.getCourse().add(c2);

		em.getTransaction().begin();
		
		em.persist(s1);
		em.persist(s2);
//		em.persist(c1);
//		em.persist(c2);
		
		em.getTransaction().commit();
		
		System.out.println("done");
		
		List<Student> studentList = em.find(Course.class, 2).getStudent();
		
		System.out.println(studentList);
		
		/* 
		 * [Student [roll=1, name=abbas, email=dfsjhf@gmail.com, mobile=86767], Student [roll=3, name=jay, email=sadksjhf@gmail.com, mobile=867236767]] 		 * 
		 */
		
		List<Course> courseList = em.find(Student.class, 1).getCourse();
		
		System.out.println(courseList);
		
		/*
		[Course [courseId=2, courseName=Java Backend, duration=2 month, fee=3200], Course [courseId=4, courseName=javascript, duration=2 month, fee=3200]]
		*/
	}

}

/* OUTPUT: 
 * 
 * mysql> select * from Course;
+----------+--------------+----------+------+
| courseId | courseName   | duration | fee  |
+----------+--------------+----------+------+
|        2 | Java Backend | 2 month  | 3200 |
|        4 | javascript   | 2 month  | 3200 |
+----------+--------------+----------+------+
2 rows in set (0.01 sec)

mysql> select * from Student;
+------+--------------------+-----------+-------+
| roll | email              | mobile    | name  |
+------+--------------------+-----------+-------+
|    1 | dfsjhf@gmail.com   | 86767     | abbas |
|    3 | sadksjhf@gmail.com | 867236767 | jay   |
+------+--------------------+-----------+-------+
2 rows in set (0.00 sec)

mysql> select * from Student_Course;
+--------------+-----------------+
| student_roll | course_courseId |
+--------------+-----------------+
|            1 |               2 |
|            1 |               4 |
|            3 |               2 |
|            3 |               4 |
+--------------+-----------------+
4 rows in set (0.00 sec)
 * 
 * 
 * 
 * 
 * 
 */
