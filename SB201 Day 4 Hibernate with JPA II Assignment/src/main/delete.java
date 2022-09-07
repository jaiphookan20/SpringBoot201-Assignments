package sb201_day4;

public class delete {
  public static void main(String[] args) {
	EmpDao em=new EmpDaoImpl();
	
    try {
		System.out.println(em.deleteEmployeeById(2));
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
