package loginPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;

//import javax.resource.spi.ConnectionManager;

public class UserDAO {
	
	 static Connection currentCon = null; 
	 static ResultSet rs = null;
	 
	 static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_05c37232add5cca";
		
	 static final String USER = "b077599f12415c";
	 static final String PASS = "3058f590";

	 
	 
	 public static UserBean login(UserBean bean) {
		 
		 Statement stmt = null; 
		 String username = bean.getUsername(); 
		 String password = bean.getPassword(); 
		 
		 String searchQuery = 
				 "select * from user_detail where USER_ID='" 
				+ username 
				+ "' AND PASSWD='" 
				+ password 
				+ "'";
		 
		 System.out.println("Your user name is " + username); 
		 System.out.println("Your password is " + password); 
		 System.out.println("Query: "+searchQuery);
		 
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 
			 System.out.println("Connecting to database...");
			 currentCon = DriverManager.getConnection(DB_URL,USER,PASS); 
			 System.out.println("Connected to database...");
			 
			 stmt=currentCon.createStatement(); 
			 rs = stmt.executeQuery(searchQuery); 
			 boolean more = rs.next();
			 
			 if(!more) {
				 System.out.println("Sorry, you are not a registered user! Please sign up first"); 
				 bean.setValid(false);
			 }
			 else if(more){
				 String firstName = rs.getString("FirstName"); 
				 String lastName = rs.getString("LastName");
				 
				 System.out.println("Welcome " + firstName); 
				 bean.setFirstName(firstName); 
				 bean.setLastName(lastName); 
				 bean.setValid(true);
			 }
		 } catch(Exception ex) {
			 System.out.println("Log In failed: An Exception has occurred! " + ex);
		 }
		 finally {
			 if (rs != null) { 
				 try { 
					 rs.close(); 
					 } catch (Exception e) {} 
				 rs = null; 
				 }
			 
			 if (stmt != null) { 
				 try { 
					 stmt.close(); 
					 } catch (Exception e) {} 
				 stmt = null; 
				 }
			 if (currentCon != null) { 
				 try { 
					 currentCon.close(); 
					 } catch (Exception e) { 
						 
					 } 
				 currentCon = null; 
				 }
		 }
		 return bean;
	 }

}
