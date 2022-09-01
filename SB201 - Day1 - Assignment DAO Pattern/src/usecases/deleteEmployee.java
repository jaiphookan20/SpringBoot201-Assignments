package usecases;

import java.util.Scanner;

import dao.EmployeeDAO;
import dao.EmployeeDAOImp;

public class deleteEmployee {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID of Employee you want to delete from table : ");
		int empId = sc.nextInt();
		
		EmployeeDAO dao = new EmployeeDAOImp();
		
		boolean result = dao.deleteEmployee(empId);
		
		System.out.println(result);

	}

}
