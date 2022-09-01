package usecases;

import java.util.Scanner;

import dao.EmployeeDAO;
import dao.EmployeeDAOImp;
import exceptions.EmployeeException;

public class getAddressOfEmployee {

	public static void main(String[] args) {
		
		EmployeeDAO dao = new EmployeeDAOImp();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee ID for the Address you want : ");
		int empId = sc.nextInt();
		
		try {
			String result = dao.getAddressOfEmployee(empId);
			System.out.println("Employee Address: " + result);
		} 
		
		catch (EmployeeException e) {
			
			e.printStackTrace();
		}

	}

}
