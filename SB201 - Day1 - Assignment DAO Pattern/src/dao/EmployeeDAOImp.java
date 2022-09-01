package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionPackage.ProvideConnection;
import exceptions.EmployeeException;
import model.Employee;

public class EmployeeDAOImp implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		
		List<Employee> employeesList = new ArrayList<>();
		
		try(Connection conn = ProvideConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from emp");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r = rs.getInt("empId");
				String n = rs.getString("name");
				String a = rs.getString("address");
				int s = rs.getInt("salary");
				
				
				Employee empObj = new Employee(r, n, a, s);
				
				employeesList.add(empObj);
			}
			
			if(employeesList.size() == 0) {
				throw new EmployeeException("No Employee found..");
			}
			
		} 
		
		catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return employeesList;
	}

	@Override
	public String getAddressOfEmployee(int empId) throws EmployeeException {
		
		String result = "No Address Obtained....";
		
		try(Connection conn = ProvideConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select address from emp where empId = ?");
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				result = rs.getString("address");
				
//				System.out.println("Employee Address: "+ a);
				
			}else
				throw new EmployeeException("Employee address does not exist with" + empId);
			
		}
		
		catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return result;
	}

	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		String ans = "Bonus not given";
		
		try(Connection conn = ProvideConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("UPDATE emp SET salary = salary + ? where empId = ?");
			ps.setInt(1, bonus);
			ps.setInt(2, empId);
            
            
            int x = ps.executeUpdate();
            
            if (x > 0) {
                ans = " bonus of " + bonus + " given to " + x + " employees";
            }
				
			else {
				System.out.println("Bonus provided to 0 employees");
			}
				
			
		}
		
		catch (SQLException e) {
			ans = e.getMessage();
		}
		

		return ans;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean result = false;
		
		try(Connection conn = ProvideConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from emp where empID = ?");
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			int x = ps.executeUpdate();
            
			if (x > 0) {
				result = true;
				System.out.println("Employee with empID " + empId + " deleted successfully");
            }
			else {
				System.out.println("Employee with empID " + empId + " was NOT DELETED");
			}
			
		}
		
		catch (SQLException e) {
			e.getMessage();
		}
		
		return result;
	}

	@Override
	public String[] getNameAndAddress(int empId) throws EmployeeException {
		String[] result = null;
		
		try(Connection conn = ProvideConnection.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select name, address from emp where empID = ?");
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			ArrayList<String> namesAddressList = new ArrayList<String>();
			
			
			if(rs.next()) {
				
				String n = rs.getString("name");
				String a = rs.getString("address");
				namesAddressList.add(n);
				namesAddressList.add(a);
				
				// finally turn the array lists into arrays - if really needed
				
				String[] nameAddressArr = new String[namesAddressList.size()];
				result = namesAddressList.toArray(nameAddressArr);	
			}
			
			else {
				System.out.println("Employee Name & Address not Obtained");
			}
				
		} 
		
		catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		return result;
	}
	
	
}
