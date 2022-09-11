package EagerLazyLoading;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utility.EmployeeUtility;

public class Main2 {
	
	/*
	 * ● Map the above Customer and Address classes.
	   
	   ● Create 2 Customer objects and each customer should have 2
		 addresses. a.homeAdderss b. officeAddress
	   
	   ● Write a JPQL to get all addresses of a customer based on cid.
		 And print the details
	   
	   ● Make use fetch type eager
	 * 

	 */
		
	public static void main(String[] args) {
		
		EntityManager em = EmployeeUtility.ProvideConnection();
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		
		c1.setName("Jai");
		c1.setMobileNumber(998640);
		c1.setEmail("jai@gmail.com");
		
		c2.setName("Shas");
		c2.setMobileNumber(90012);
		c2.setEmail("shas@gmail.com");
		
		
		em.getTransaction().begin();
		
		c1.getAddresses().add(new Address("Assam", "Guwahati", "781024"));
		c1.getAddresses().add(new Address("MH", "Mumbai", "5505"));
		
		c2.getAddresses().add(new Address("Delhi", "HKV", "00001"));
		c2.getAddresses().add(new Address("Karnataka", "Bengaluru", "110005"));
		
		
		em.persist(c1);
		em.persist(c2);
		
		em.getTransaction().commit();
		
		/* Write a JPQL to get all addresses of a customer based on cid */
		Query q = em.createQuery("from Customer where cid=?1");
		q.setParameter(1, 1); // if you want to get customer details for Jai and his address
//		q.setParameter(1, 2); if you want to get customer details for Shaswati & her Address
		
		List<Customer> c = q.getResultList();
		
		
		/* ● Write a JPQL to get all addresses of a customer based on cid. */
		for(Customer cus : c) 
		{
        	
         System.out.println(cus.getCid());
       	 System.out.println(cus.getName());
       	 System.out.println(cus.getEmail());
       	 System.out.println(cus.getMobileNumber());
       	 
       	 
       	 List<Address> adrs = cus.getAddresses();
       	 
       	 for(Address a : adrs) {
       		 System.out.println(a.getState());
       		 System.out.println(a.getCity());
       		 System.out.println(a.getPincode());
       	 	}
		}

	}	
	
}
