package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeUtility {
	
	private static EntityManagerFactory emf;
	
	/* This Persistence.createEntityManagerFactory needs to be in a static block */
	static {
		emf = Persistence.createEntityManagerFactory("empUnit");
	}
	
	public static EntityManager ProvideConnection() {
		return emf.createEntityManager();
	}

}
