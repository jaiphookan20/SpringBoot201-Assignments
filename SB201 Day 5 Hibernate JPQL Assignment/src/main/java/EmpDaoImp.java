package sb201_day5;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EmpDaoImp implements EmpDao {

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException {
		// TODO Auto-generated method stub
		EntityManager em= EmpUtility.ProvideConnection();
            Query  q=  em.createQuery("from Employee");		
            
            List<Employee> li=q.getResultList();
            em.close();
            return li;
		
	}

	@Override
	public List<Employee> getEmployeesByAddress(String address) throws EmployeeException {
		// TODO Auto-generated method stub
		EntityManager em= EmpUtility.ProvideConnection();
        Query  q=  em.createQuery("from Employee where address=?1");
        
        q.setParameter(1, address);
        
        List<Employee> li=q.getResultList();
        em.close();
        
        return li;
	}

	@Override
	public List<Employee> getAllEmployeeWithRangeSalary(int startSalary, int endSalary) throws EmployeeException {
		// TODO Auto-generated method stub
		EntityManager em= EmpUtility.ProvideConnection();
        Query  q=  em.createQuery("from Employee where salary>=?1 and salary<=?2");
        
        q.setParameter(1,startSalary);
        q.setParameter(2, endSalary);
        
        List<Employee> li=q.getResultList();
        em.close();
        
        return li;
	}

	@Override
	public Object[] getEmployeeNameAndSalary(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		EntityManager em= EmpUtility.ProvideConnection();
        Query  q=  em.createQuery("select name,salary from Employee where empid=?1");
        
        q.setParameter(1,empId);
   
        
        Object[] li=(Object[])q.getSingleResult();
        em.close();
        
        return li;
	}

	@Override
	public int getEmployeeSalaryById(int empId) throws EmployeeException {
		// TODO Auto-generated method stub
		EntityManager em= EmpUtility.ProvideConnection();
        Query  q=  em.createQuery("select salary from Employee where empid=?1");
        
        q.setParameter(1,empId);
   
        
        int li=(Integer)q.getSingleResult();
        em.close();
        
        return li;
	}

}
