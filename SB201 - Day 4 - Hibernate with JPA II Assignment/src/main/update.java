package sb201_day4;

public class update {
    
	public static void main(String[] args) {
		EmpDao em=new EmpDaoImpl();
		
		Employee e=new Employee(3,"jay","raj",24569);
	
		
		try {
			System.out.println(em.updateEmployee(e));
		} catch (EmployeeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
