package hybernate1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class empimp implements Emp {

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentUnit");
	EntityManager em= 	emf.createEntityManager();
	
	em.getTransaction().begin();
	
	em.persist(emp);
	System.out.println("Added");
	em.getTransaction().commit();
		em.close();
	}

	@Override
	public String getAddressOfEmployee(int empId) {
		// TODO Auto-generated method stub
		String add=null;
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentUnit");
		EntityManager em= 	emf.createEntityManager();
		
		Employee emp=em.find(Employee.class, empId);
		if(emp!=null) {
			add=emp.getAddress();
		}
		else {
			add="not found";
		}
		
		return add;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		// TODO Auto-generated method stub
           String ans=null;
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentUnit");
		
		EntityManager em= 	emf.createEntityManager();
		
		Employee emp=em.find(Employee.class, empId);
		
		if(emp==null) {
			ans="not found";
		
		}
		else {
			
			em.getTransaction().begin();
			
		       emp.setSalary(emp.getSalary()+bonus);
		
			em.getTransaction().commit();
			ans="bonus given";
		}
		em.close();
		
		return ans;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		boolean ans=false;
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("studentUnit");
		EntityManager em= emf.createEntityManager();
		
		Employee emp=em.find(Employee.class, empId);
		
		if(emp!=null) {
		em.getTransaction().begin();
		em.remove(emp);
		ans=true;
		em.getTransaction().commit();
		
	   
	}
		else {
			ans=false;
		}
		em.close();
	return ans;
}
	}

