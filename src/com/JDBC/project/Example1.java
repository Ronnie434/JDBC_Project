package com.JDBC.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	public class Example1 {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/Ronak?createDatabaseIfNotExist=true";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "991115";
	public static void main(String[] args) {
	Connection conn = null;
	Statement stmt = null;
	try{
	//STEP 2: Register JDBC driver
	Class.forName(JDBC_DRIVER);
	//STEP 3: Open a connection
	System.out.println("Connecting to database...");
	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	//STEP 4: Execute a query
	System.out.println("Creating table in given database...");
	stmt = conn.createStatement();
	String dropTable = "DROP TABLE IF EXISTS EMPLOYEES";
	stmt.executeUpdate(dropTable);
	String sql = "CREATE TABLE EMPLOYEES " +
	"(id INTEGER not NULL, " +
	" first VARCHAR(255), " +
	" last VARCHAR(255), " +
	" age INTEGER, " +
	" PRIMARY KEY ( id ))";
	stmt.executeUpdate(sql);
	System.out.println("Created table in given database...");
	System.out.println("Inserting records into the table...");
    sql ="INSERT INTO Employees VALUES (100, 'Kriss', 'Kurian', 18)";
	stmt.executeUpdate(sql);
	sql = "INSERT INTO Employees VALUES (101, 'Enrique', 'John', 25)";
	stmt.executeUpdate(sql);
	sql= "INSERT INTO Employees VALUES(102, 'Taylor', 'Swift', 30)";
	stmt.executeUpdate(sql);
	sql= "INSERT INTO Employees VALUES(103, 'Linkin', 'Park', 28)";
	stmt.executeUpdate(sql);
	System.out.println("Inserted records into the table...");
	
	
	
	System.out.println("Creating statement...");
	sql = "SELECT id, first, last, age FROM Employees";
	ResultSet rs = stmt.executeQuery(sql);
	//STEP 5: Extract data from result set
	while(rs.next()){
	//Retrieve by column name
	int id = rs.getInt("id");
	int age = rs.getInt("age");
	String first = rs.getString("first");
	String last = rs.getString("last");
	//Display values
	System.out.print("ID: " + id);
	System.out.print(", Age: " + age);
	System.out.print(", First: " + first);
	System.out.println(", Last: " + last);
	}
	//STEP 6: Clean-up environment
	rs.close();
	stmt.close();
	conn.close();
	}catch(SQLException se){
	//Handle errors for JDBC
	se.printStackTrace();
	}catch(Exception e){
	//Handle errors for Class.forName
	e.printStackTrace();
	}finally{
	//finally block used to close resources
	try{
	if(stmt!=null)
	stmt.close();
	}catch(SQLException se2){
	}// nothing can be done
	try{
	if(conn!=null)
	conn.close();
	}catch(SQLException se){
	se.printStackTrace();
	}//end finally try
	}//end try
	System.out.println("Goodbye!");
	}//end main
	} // end Example
