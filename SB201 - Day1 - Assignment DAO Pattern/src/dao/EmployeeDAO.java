package dao;

import java.util.List;

import exceptions.EmployeeException;

import model.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployee() throws EmployeeException;
	
	public String getAddressOfEmployee(int empId) throws EmployeeException;
	
	public String giveBonusToEmployee(int empId, int bonus);
	
	public boolean deleteEmployee(int empId);
	
	public String[] getNameAndAddress(int empId) throws EmployeeException;

}
