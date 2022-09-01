package usecases;

import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImp;
import exceptions.EmployeeException;
import model.Employee;

public class getAllEmployee {

	public static void main(String[] args) {
		
		EmployeeDAO dao = new EmployeeDAOImp();
		
		try {
			List<Employee> employees = dao.getAllEmployee();
			
			employees.forEach(e -> {
				System.out.println(e);
			});
		} 
		
		
		catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		}

	}

}
