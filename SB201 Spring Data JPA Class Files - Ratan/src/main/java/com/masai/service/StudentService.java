package com.masai.service;

import java.util.List;

import com.masai.exceptions.StudentException;
import com.masai.model.Student;
import com.masai.model.StudentDTO;

public interface StudentService {
	
	/* Here return type is Student obj itself, why? Because I have used the auto-generated Id. 
	 * We are expecting the user to provide a Student body object
	 * without any PK (roll/id). This method will persist the Student, generate a unique Id and it will
	 * return the Student which will have the generated Id
	 * */
	public Student saveStudent(Student student);
	
	public Student getStudentByRoll(Integer roll)throws StudentException;

	public List<Student> getAllStudentDetails()throws StudentException;
	
	
	/* DELETE Student by Roll Number -> 1:29 min - 1:35min onwards. Plus, Why is the return type Student? This is because after deleting it, we want to return the deleted Student in order to utilize it to show some details */
	public Student deleteStudentByRoll(Integer roll)throws StudentException;
	
	
	public Student updateStudentDetails(Student student)throws StudentException;
	
	/* updateStudentMarks -> 1hr:42 mins - 1:43 mins */
	public Student updateStudentMarks(Integer roll, Integer graceMarks)throws StudentException;
	
	public List<Student> getStudentByName(String name)throws StudentException;
	
	public  List<StudentDTO> getStudentNameAndMarks()throws StudentException;
	
	
	
	
}







