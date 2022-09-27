package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Student;
import com.masai.model.StudentDTO;

/* The implementation of this StudentDao is given in such a way that it is registered in the 
 * container as a Spring Bean, so it's object in (service layer) will automatically be @Autowired 
 * but for more clarity - we can provide the @Repository annotation - so that we can understand 
 * that is a Data Access Layer related Interface
 * */

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

	public List<Student> findByName(String name);
	
	@Query("select new com.masai.model.StudentDTO(s.name, s.marks) from Student s")
	public List<StudentDTO> getStudentNameAndMarks();
	
}
