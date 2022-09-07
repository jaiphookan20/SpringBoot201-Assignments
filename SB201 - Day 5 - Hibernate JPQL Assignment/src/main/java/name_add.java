package sb201_day5;

public class name_add {

	
	 public static void main(String[] args) {
			EmpDao e= new EmpDaoImp();
			
			try {
				Object[] or=e.getEmployeeNameAndSalary(3);
				System.out.println("name " +or[0]);
				System.out.println("salary "+or[1]);
			} catch (EmployeeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
}
