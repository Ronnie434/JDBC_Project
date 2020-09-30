package com.JDBC.project;

import java.sql.DriverManager;


import java.sql.*;

/*Write a program to establish the connection between 
 * Java program to database.The sysdate command is used in SQL to 
 * print current date.  
 * 
 */
public class Example3 {
	public static final String DBURL = "jdbc:mysql://localhost:3306/Prasanna";
    public static final String DBUSER = "root";
    public static final String DBPASS = "visual123";
    public static void main(String args[])
    {
         try
         {
              //Load the driver
              Class.forName("com.mysql.jdbc.Driver");
              //Cretae the connection object
              Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
              //Create the Statement Object
              Statement stmt = con.createStatement();
              //Excute the SQL query
              ResultSet rs = stmt.executeQuery("Select sysdate()");
              if (con != null)
              {
                   System.out.println("Connection is established.\n");
                   while (rs.next())
                        System.out.println ("Current Date is: "+rs.getDate(1));
              }
              else
                   System.out.println("Connection is not esablished");
  
              //Closing the connection object
              con.close();
              stmt.close();
              rs.close();
         }
         catch(Exception ex)
         {
              ex.printStackTrace();
         }
    }

}
