package sb201_day4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmpUtility {

	
	private static EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("empUnit");
	}
	public static EntityManager ProvideConnection() {
		return emf.createEntityManager();
	}
}
