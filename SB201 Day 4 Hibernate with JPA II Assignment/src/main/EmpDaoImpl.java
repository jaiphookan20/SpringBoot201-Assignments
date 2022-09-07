package sb201_day4;

import javax.persistence.EntityManager;

public class EmpDaoImpl implements EmpDao {

	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeException {
	
		Employee e=null;
		EntityManager em=EmpUtility.ProvideConnection();
		
		em.getTransaction().begin();
		
		
	
		em.persist(employee);
		e=em.find(Employee.class,employee.getId());
		em.getTransaction().commit();
		
		
		
		
		
		
		
		
		return e;
	}

	@Override
	public Employee getEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		EntityManager em=EmpUtility.ProvideConnection();
		return  em.find(Employee.class, empId);
		
	}

	@Override
	public Employee deleteEmployeeById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee e=null;
		EntityManager em=EmpUtility.ProvideConnection();
		e= em.find(Employee.class, empId);
		em.getTransaction().begin();
		
		
	
		em.remove(e);
		
		em.getTransaction().commit();
		
		
		
		
		
		
		
		
		return e;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		
		EntityManager em=EmpUtility.ProvideConnection();
		Employee e= em.find(Employee.class, employee.getId());
		em.getTransaction().begin();
		
		
	
		em.merge(employee);
		
		em.getTransaction().commit();
		
		
		
		
		
		
		
		
		return e;
	}
	

}
