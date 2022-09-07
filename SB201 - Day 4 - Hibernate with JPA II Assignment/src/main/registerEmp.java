package sb201_day4;



public class registerEmp {
  
	public static void main(String[] args) {
		EmpDao em= new EmpDaoImpl();
		
		Employee e=new Employee();
		
		e.setName("Abbas");
		e.setAddress("Jam");
		e.setSalary(23900);
		
		try {
			System.out.println(em.registerEmployee(e));
		} catch (EmployeeException e1) {
			// TODO Auto-generated catch block
	         e1.getMessage();
		}
		
		
	}
	
	
}
