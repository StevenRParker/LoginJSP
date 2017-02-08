package loginPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TableCreator {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_05c37232add5cca";
	
	static final String USER = "b077599f12415c";
	static final String PASS = "3058f590";

    public static void main(String [] args){
    	
		Connection conn = null;
		Statement stmt = null;
		try{
			//step 2: register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Step 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connected to database...");
			
			 //STEP 4: Execute a query
			stmt = conn.createStatement();
			String sql = "CREATE TABLE STUDENT_DETAIL " +
	                   " (STUDENT_ID VARCHAR(6), " +
	                   " NAME VARCHAR(30), " + 
	                   " SUBJECT VARCHAR(30), " + 
	                   " SCORE INTEGER, " + 
	                   " PRIMARY KEY ( STUDENT_ID ))"; 

	     // stmt.executeUpdate(sql);
	      System.out.println("Created table STUDENT_DETAIL in given database...");
	      
	      sql = "CREATE TABLE USER_DETAIL " +
                  "(USER_ID VARCHAR(6), " + 
                  " PASSWD VARCHAR(8), " + 
                  " PRIMARY KEY ( USER_ID ));"; 
	      stmt.executeUpdate(sql);
	      System.out.println("Created table USER_DETAIL in given database...");
	      
	      
	      // now we will insert some records
		      System.out.println("Inserting records into STUDENT_DETAIL...");
		      stmt = conn.createStatement();
		      
		      
		      sql = "INSERT INTO STUDENT_DETAIL " +
		                   "VALUES ('St0', 'Stevie', 'Math', 100)";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO STUDENT_DETAIL " +
		                   "VALUES ('St1', 'Blair', 'History', 100)";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO STUDENT_DETAIL " +
		                   "VALUES ('St2', 'Lauren', 'Physics', 100)";
		      stmt.executeUpdate(sql);
		      System.out.println("Inserted records into the STUDENT_DETAIL...");
		      
		      
		      System.out.println("Inserting records into USER_DETAIL...");
		      sql = "INSERT INTO USER_DETAIL " +
		                   "VALUES('user0', 'pass0')";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO USER_DETAIL " +
		                   "VALUES('user1', 'pass1')";
		      stmt.executeUpdate(sql);           
		      sql = "INSERT INTO USER_DETAIL " +
	                   "VALUES('user2', 'pass2')";
	      stmt.executeUpdate(sql);           
		      System.out.println("Inserted records into the USER_DETAIL...");
		}//ends try
		
		 
		catch (ClassNotFoundException | SQLException e){
			System.out.println(e.getClass().getName());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}


	}//ends main
	
}//ends class
