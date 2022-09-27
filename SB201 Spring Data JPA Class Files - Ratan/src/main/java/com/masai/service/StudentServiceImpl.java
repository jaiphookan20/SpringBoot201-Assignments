package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.StudentException;
import com.masai.model.Student;
import com.masai.model.StudentDTO;
import com.masai.repository.StudentDao;

/*  This is our Service Layer class thus we add the @Service annotation. Thus, 
	this class will be registered with the container as a Spring Bean  */

@Service
public class StudentServiceImpl implements StudentService{
	
	/*  In order for our service layer methods to be implemented, we need to be able to talk to our
	 * data access layer, so we inject the StudentDao Interface obj variable (which extends Jpa Repository)
	 * here and apply the @Autowired property on it  */
	
	
	@Autowired
	private StudentDao dao;   
	/*	Crucial interview Q: How is it that an interface obj has been injected in your implementation....
	   class through Autowired annotation. You have not provided it's implementation obj by the interface obj. Why ?
	   How is the interface injected here? The StudentDao dao is indeed an interface obj, but since
	   that interface is EXTENDING the JpaRepository -> Spring Data JPA framework has provided the
	   implementation and not only that, registers that object in the Spring Container so that whenever
	   we need the dao object, automatically the registered/autowired object of the implementation will
	   be injected over here 
	 */
	
	
	/* NOTE: Each of these methods are individually a service, which we expose to the REST API */
	
	/* Student saveStudent -> Here return type is Student obj itself, why? Because I have used the auto-generated Id. 
       We are expecting the user to provide a Student body object without any PK (roll/id). 

	   This method will persist the Student, generate a unique Id and it will
	   return the Student which will have the generated Id
    */
	@Override
	public Student saveStudent(Student student) {
		
		Student savedStudent= dao.save(student);
		
		return savedStudent;
	}
	
	/* Student getStudentByRoll -> 54 - 57mins */
	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException {
		
		
			Optional<Student> opt= dao.findById(roll);
			
			/*
			if(opt.isPresent()) {
				return opt.get();
			}else
				throw new StudentException("Student does not exist with roll :"+roll);
			 */
		
		return opt.orElseThrow(() -> new StudentException("Student does not exist with Roll :"+roll) );
			
		
	}

	/* List<Student> getAllStudentDetails(): 1hr :10 - 1hr 13 mins */
	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		
		
		List<Student> students= dao.findAll();
		
		if(students.size() > 0)
			return students;
		else
			throw new StudentException("No student found..");
		
	}
	
	/* DELETE Student by Roll Number ->  1:30 - 1:35 min. Contd below: POSTMAN Impl..... 
	 * Why is the return type Student? This is because after deleting it, we want to return the deleted Student in order to utilize it to show some details 
	 * 
 
	 * */
	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {
		
		/*
		 * Student existingStudent= dao.findById(roll).orElseThrow(() -> new StudentException("Student does not exist with Roll "+roll));;
		 * 
		 * dao.delete(existingStudent); 
		 * 
		 * return existingStudent;
		 */
		
		Optional<Student> opt = dao.findById(roll);
		
		if(opt.isPresent()) {
			
			 Student existingStudent= opt.get();
			 
			 dao.delete(existingStudent);
			
			 return existingStudent;
		}
		
		else
			throw new StudentException("Student does not exist with Roll :"+roll);
		
	}
	
	/* updateStudentDetails -> 1hr:43 mins - 1:47 mins */
	@Override
	public Student updateStudentDetails(Student student) throws StudentException {
		
		Optional<Student> opt= dao.findById(student.getRoll());
		
		
		if(opt.isPresent()) {
			
			return dao.save(student); 
			/* if id is ALREADY there for Student, then it will perform the UPDATE ie merge it . 
			 * 
			 *  If id is NOT THERE ALREADY -> Then it will perform the SAVE method 
			 *  
			 */
			
			
			/* NOTE: here SAVE method will perform AS "saveOrUpdate" based on Id field (CRUCIAL) 
			 * SAVE METHOD acts as SAVE OR UPDATE (saveOrUpdate)
			 */
			 
		}
		else
			throw new StudentException("Invalid Student details");
		
	}

	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {
		
		Optional<Student> opt= dao.findById(roll);
		
		if(opt.isPresent()) {
			
			Student existingStudent= opt.get();
			
			
			existingStudent.setMarks(existingStudent.getMarks()+graceMarks);
			
			return dao.save(existingStudent);
			
			
		}else
			throw new StudentException("Student does not exist with Roll :"+roll);
		
		
		
		
	}

	@Override
	public List<Student> getStudentByName(String name) throws StudentException {
		
		
		
		List<Student> students= dao.findByName(name);
		
		
		if(students.size() > 0)
			return students;
		else
			throw new StudentException("Student does not exist with Name "+name);
		
	
		
	}

	/* DTO: We use a DTO object when we want to send partial data eg send only name & marks instead of all fields like roll, name, & marks */
	
	
	@Override
	public  List<StudentDTO> getStudentNameAndMarks() throws StudentException {
		
		List<StudentDTO> dtos= dao.getStudentNameAndMarks();
		
		if(dtos.size() >0)
			return dtos;
		else
			throw new StudentException("No record found");
		
		
	}
	
	
	
	

}
