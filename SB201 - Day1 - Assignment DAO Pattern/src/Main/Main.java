package Main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dao.EmployeeDAOImp;
import exceptions.EmployeeException;
import model.Employee;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee ID: ");
		int empId = sc.nextInt();
		System.out.println("Enter Bonus you want to provide to the Employee: ");
		int bonus = sc.nextInt();
		
		EmployeeDAO dao = new EmployeeDAOImp();
		
		/*   getAllEmployee   */
		try {
			List<Employee> employees = dao.getAllEmployee();
			
			employees.forEach(e -> {
				System.out.println(e);
			});
		} 
		
		catch (EmployeeException e) {
			
			System.out.println(e.getMessage());
		}
		
		/*   getNameAndAddress   */
		try {
			String[] result = dao.getNameAndAddress(empId);
			
			System.out.println(Arrays.toString(result));
		} 
		
		catch (EmployeeException e) {
			
			e.printStackTrace();
		}
		
		/*   getAddressOfEmployee   */
		try {
			String result = dao.getAddressOfEmployee(empId);
			System.out.println("Employee Address: " + result);
		} 
		
		catch (EmployeeException e) {
			
			e.printStackTrace();
		}
		
//		/*   giveBonusToEmployee   */
		String result = dao.giveBonusToEmployee(empId, bonus);
		
		System.out.println(result);
		
		
		/* Delete Employee */ 
		boolean ans = dao.deleteEmployee(empId);
		
		System.out.println(ans);

	}	

}
