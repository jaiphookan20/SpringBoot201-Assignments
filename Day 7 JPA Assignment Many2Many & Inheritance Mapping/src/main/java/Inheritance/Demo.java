package Inheritance;

import javax.persistence.EntityManager;

import utility.EmployeeUtility;

public class Demo {

	public static void main(String[] args) {
		
		EntityManager em = EmployeeUtility.ProvideConnection();
		
		Employee emp1 = new Employee();
		emp1.setName("Jai");
		emp1.setHomeAddress(new Address("Assam", "Ghy", "7824"));
		emp1.setOfficeAddress(new Address("Mh", "Mumbai", "5505"));
		emp1.setSalary(5000);
		
		Employee emp2 = new Employee();
		emp2.setName("Shaswati");
		emp2.setHomeAddress(new Address("Haryana", "Gurgaon", "00012"));
		emp2.setOfficeAddress(new Address("Mh", "Pune", "5501"));
		emp2.setSalary(15000);
		
		Employee emp3 = new Employee();
		emp3.setName("Shreya");
		emp3.setHomeAddress(new Address("Assam", "GS Road", "00069"));
		emp3.setOfficeAddress(new Address("UK", "London", "00001"));
		emp3.setSalary(3000);
		
		em.getTransaction().begin();
	    
		em.persist(emp1);
		em.persist(emp2);
		em.persist(emp3);
	    
	    em.getTransaction().commit();
	      
	    em.close();
	}

}

/* Output:  

mysql> show tables;
+--------------------+
| Tables_in_db1      |
+--------------------+
| Employee           |
| hibernate_sequence |
| Person             |
+--------------------+
3 rows in set (0.03 sec)


mysql> select * from Employee;
+-----------+--------------+------------+-------------+----------------+--------------+--------+-----+
| HOME_CITY | HOME_PINCODE | HOME_STATE | OFFICE_CITY | OFFICE_PINCODE | OFFICE_STATE | salary | pid |
+-----------+--------------+------------+-------------+----------------+--------------+--------+-----+
| Ghy       | 7824         | Assam      | Mumbai      | 5505           | Mh           |   5000 |   1 |
| Gurgaon   | 00012        | Haryana    | Pune        | 5501           | Mh           |  15000 |   2 |
| GS Road   | 00069        | Assam      | London      | 00001          | UK           |   3000 |   3 |
+-----------+--------------+------------+-------------+----------------+--------------+--------+-----+
3 rows in set (0.00 sec)

mysql> select * from Person;
+-----+----------+
| pid | name     |
+-----+----------+
|   1 | Jai      |
|   2 | Shaswati |
|   3 | Shreya   |
+-----+----------+
3 rows in set (0.00 sec)












*/