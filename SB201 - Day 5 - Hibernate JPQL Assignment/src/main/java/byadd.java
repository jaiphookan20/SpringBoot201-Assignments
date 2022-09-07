package sb201_day5;

public class byadd {
	
	   public static void main(String[] args) {
			EmpDao e= new EmpDaoImp();
			
			try {
				System.out.println(e.getEmployeesByAddress("jay"));
			} catch (EmployeeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

}
