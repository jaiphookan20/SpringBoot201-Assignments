package OneToManyBiDirectional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utility.EmployeeUtility;

public class Demo2 {

	public static void main(String[] args) {
		
		EntityManager em = EmployeeUtility.ProvideConnection();
		
		/* 
		 * Write a JPQL to get the Collage details based on studentRoll and print the details.
		 */
		
		Query q= em.createQuery("select student from Collage where collageId=1");
		System.out.println(q);
		
		List<Student> s= q.getResultList();
		
		System.out.println(s);
		
		Query q1= em.createQuery("select collage from Student where studentRoll=2");
		System.out.println(q1);
		
		Collage  c= (Collage) q1.getSingleResult();
		System.out.println(c);

	}

}
