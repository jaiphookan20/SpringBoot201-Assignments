package usecases;

import java.util.Scanner;

import dao.EmployeeDAO;
import dao.EmployeeDAOImp;

public class giveBonusToEmployee {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID: ");
		int empId = sc.nextInt();
		System.out.println("Enter Bonus you want to provide to the Employee: ");
		int bonus = sc.nextInt();
		
		EmployeeDAO dao = new EmployeeDAOImp();
		
		String result = dao.giveBonusToEmployee(empId, bonus);
		
		System.out.println(result);
	}

}
