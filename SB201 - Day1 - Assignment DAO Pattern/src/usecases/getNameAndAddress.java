package usecases;

import java.util.Arrays;
import java.util.Scanner;

import dao.EmployeeDAO;
import dao.EmployeeDAOImp;
import exceptions.EmployeeException;

public class getNameAndAddress {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter employee ID: ");
		int empId = sc.nextInt();
		
		
		EmployeeDAO dao = new EmployeeDAOImp();
		
		try {
			String[] result = dao.getNameAndAddress(empId);
			
			System.out.println(Arrays.toString(result));
		} 
		
		catch (EmployeeException e) {
			
			e.printStackTrace();
		}

	}

}
