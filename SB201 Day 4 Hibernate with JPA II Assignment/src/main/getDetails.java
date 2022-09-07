package sb201_day4;

public class getDetails {
  public static void main(String[] args) {
		EmpDao em= new EmpDaoImpl();
		
		try {
			
			System.out.println(em.getEmployeeById(3));
		}
		
			catch (EmployeeException e) {
				 e=new EmployeeException("Not found");
		}
		
			
		}
} 

