package loginPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	static Connection con; 
	static String url;
	
	static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_05c37232add5cca";
	
	static final String USER = "b077599f12415c";
	static final String PASS = "3058f590";
	
	public static Connection getConnection() {
		
		try {
			//String url = "jdbc:odbc:" + "DataSource"; 
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			try {
				 con = DriverManager.getConnection(DB_URL,USER,PASS);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		return con;
	}

}
