package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.StudentException;
import com.masai.model.Student;
import com.masai.model.StudentDTO;
import com.masai.service.StudentService;

/* To understand clearly the connection between the Controller, Service Layer, Dao etc -> please watch the lecture video from 40 - 42 mins (link below)... 
 * & FROM 1:20 - 1:22mins
 * 
 * https://course.masaischool.com/lectures/36420
 * */

@RestController
public class StudentController {
	
	/* In my Controller Class, I need to provide an API, by which I can expose my services ie ....
	 * service layer methods. So I need here as a dependency object - my Service layer interface variable
	 * and the Implementation object will be injected here 
	 * 	@Autowired
		private StudentService studentService; 
	*/
	
	@Autowired
	private StudentService studentService;   
	/* Injected Service Layer interface dependency. We provide @Autowired annotation on it. What happens -> 
	 * At first, it will try to inject byName, if name is not there, it will then try to inject byType, meaning if there is any
	 * implementation class of StudentService with the container -> this studentService obj variable will be injected there. 
	 * 
	 * Now with the implementation class of StudentService ie StudentImpl -> since we've have applied @Service annotation on it, this 
	 * class StudentImpl will be registered with the container. Now since StudentImpl is an implementation of StudentService interface, 
	 * the container will take this object of StudentService which has been registered with Container as a Spring Bean ->
	 * that will be injected in our Controller class as the StudentService studentService variable  
	 * */
	
	
	/* NOTE: Overview: Whenever the client gives a request with a particular URI below -> what happens is that...
	 * that particular method will talk to the Controller Layer THROUGH the Service Layer (ie the 
	 * StudentService interface & its implementation (StudentServiceImpl) object -> Which in turn 
	 * talks to the Data Access Layer through the StudentDao studentDao object in the implementation class.
	 * The StudentDao interface in turn extends the JpaRepository
	 */
	
	/* REGISTER a STUDENT: (37-39min) this method saves/registers a student, which takes a Student object from ...
	 * the client so we need to use the @RequestBody annotation. 
	 * 
	 * 48 - 49min
	 * In POSTMAN: We provide in POST: for in http://localhost:8888/students, in body we provide for eg: 
	 *  {
	 *  	"name": "Ram",
	 *  	"marks": 850 (we don't provide the Id (roll) since it is auto-generated
	 *  }
	 *  
	 *  The Output we get: 
	 *  {	
	 *  	"roll": 1, 
	 *  	"name": "Ram",
	 *  	"marks": 850 (we don't provide the Id (roll) since it is auto-generated
	 *  }
	 *  
	 *  If you provide another POST request, another row record will be added in the table
	 *  
	 *  Now, if you check in SQL, in your table, you'll find the above row provided in 'student' table
	 *  */
	@PostMapping("/students")      
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student) {
		
		Student savedStudent= studentService.saveStudent(student);
		
		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);	
	}
	
	
	
	/* GET STUDENT DETAILS BY ROLL NUM (PK) -> SETTING UP: 58mins - 1hr:01mins. API TEST on POSTMAN: 1hr:08 - 1:10   ..... (contd below)
	 * 
	 * GET: request on POSTMAN: 
	 *  For eg if we put: an invalid roll as 222:
	 *  We put http://localhost:8888/students/222 
	 *  we get output message: "student does not exist with Roll: 222" (Exception is thus properly handled)
	 *  
	 *  Remember, in POST request above, we have put only two records thus far, with roll id 1 & 2
	 *  
	 *  So now if we put a correct roll number for eg as: http://localhost:8888/students/1
	 *  we get the correct output: 
	 *  {	
	 *  	"roll": 1, 
	 *  	"name": "Ram",
	 *  	"marks": 850 (we don't provide the Id (roll) since it is auto-generated
	 *  }
	 *  
	 *  */
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable("roll") Integer roll) throws StudentException{
		Student student= studentService.getStudentByRoll(roll);
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	/* IF I WANT TO SEND PARTIAL DATA -> We SEND (THROUGH DTO): CHECK BELOW. SAME METHOD AS ABOVE EXCEPT instead of sending all details of Student, we want to send only Name & Marks of Student. 
	 * Copying example from lecture at 1: 23 - 1:25 mins
	@GetMapping("/students/{roll}")
	public ResponseEntity<StudentDTO> getStudentByRollHandler2(@PathVariable("roll") Integer roll) throws StudentException{
		
		Student student= studentService.getStudentByRoll(roll);
		
		StudentDTO dto = new StudentDTO(student.getName(), student.getMarks());
		
		return new ResponseEntity<StudentDTO>(dto, HttpStatus.OK); 
		
		/* Sending Partial data through DTO (Data Transfer Object 
	}
	*/
	
	
	/* GET: Get ALL Student Details. Controller implementation: 1:14 - 1:16. POSTMAN Impl -> 
	 *    if you put GET:  http://localhost:8888/students -> 
	 *   
	 *    No JSON body to be provided
	 *   
	 *    You should get all the students you posted through the registerStudentHandler method, in a JSON list 
	 *  
	 *  */
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentDetailsHandler() throws StudentException{
		
		List<Student> students= studentService.getAllStudentDetails();
		
		
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);	
	}
	
	
	/* DELETE Student by Roll Number 1:33 - 1:40 min. Contd below: POSTMAN Impl.....   
	 * 
	 * In POSTMAN: DELETE: ://localhost:8888/students/2 (provide path variable) 
	 * 
	 *  If you put wrong roll num - > you will get student exception error message 
	 * 	else you will get the details of the deleted student & then you can check in SQL that it is gone: 
	 *   
	 * */
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentByRollHandler(@PathVariable("roll") Integer roll) throws StudentException{
		
		Student student= studentService.deleteStudentByRoll(roll);
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
	}
	
	/* UPDATE Student: updateStudentHandler -> 1hr:45 mins - 1:49 mins. API Impl below....
	 * 
	 * In POSTMAN: PUT: http://localhost:8888/students/
	 * 
	 *  ADD BODY & No Path Variable: We have to given the Student JSON details of the Student we want to update:
	 *  IMPORTANT: Since we are choosing which Student to Update/Modify: 
	 *  We have to provide ALL Details including the Id value: otherwise it will be wrong 
	 *  For eg add: 
	 *  
	 *  {
	 *  	"roll": 1,
	 *  	"name": "Ram",
	 *  	"marks": 500
	 *  }
	 *  
	 *  If you give a wrong value, it will not be able to update it
	 *  
	 */  
	
	
	@PutMapping("/students")
	public ResponseEntity<Student> updateStudentHandler(@RequestBody Student student) throws StudentException{
		
		Student updatedStudent= studentService.updateStudentDetails(student);
		
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
		
	}
	
	/* UPDATE Student by providing PATH VARIABLE for Roll & Request Parameter (?) for Marks eg. //http://localhost:8888/students/2?gmarks=100 */
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentMarksHandler(@PathVariable("roll") Integer roll, @RequestParam("gmarks") Integer gmarks) throws StudentException{
		
		Student updatedStudent= studentService.updateStudentMarks(roll, gmarks);
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
		
	}
	
	/* GET Student by providing PATH VARIABLE for NAME (THIS SHOULD ALSO BE IN RESPONSE ENTITY - Lecturer just didn't do it */
	@GetMapping("/getstudentbyname/{name}")
	public List<Student> getStudentByNameHandler(@PathVariable String name) throws StudentException {
	
		return  studentService.getStudentByName(name);
		
	}
	
	
	/* GET Student NAME & MARKS by providing PATH VARIABLE for NAME. (THIS SHOULD ALSO BE IN RESPONSE ENTITY - Lecturer just didn't do it) */
	
	/* DTO: We use a DTO object when we want to send partial data eg send only name & marks instead of all fields like roll, name, & marks */
	
	@GetMapping("/getStudent2")
	public List<StudentDTO> getStudentNameAndMarksByRollHandler() throws StudentException {
		
		
	return  studentService.getStudentNameAndMarks();
		
		
	}
	
	
	 
	
	
	
	
	
	
}
