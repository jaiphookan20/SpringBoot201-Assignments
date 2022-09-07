package sb201_day5;

public class bysalary {
	
	 public static void main(String[] args) {
			EmpDao e= new EmpDaoImp();
			
			try {
				System.out.println(e.getAllEmployeeWithRangeSalary(50000, 55000));
			} catch (EmployeeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

}
