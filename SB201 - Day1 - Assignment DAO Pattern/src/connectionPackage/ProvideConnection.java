package connectionPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProvideConnection {
	
	/* Providing methods to encapsulate the connection creating process */

	public static Connection provideConnection() {
		
		/* This method will return the connection thus, return type is Connection 
		 * 
		 * Through this method, we have encapsulated the connection creating logic, such that
		 * any time we need to create a connection, we just need to use this method
		 */
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";
		
		
		
		try {
			conn = DriverManager.getConnection(url, "root", "qwerty123");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return conn;
		
	}

}
