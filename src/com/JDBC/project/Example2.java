package com.JDBC.project;

import java.sql.DriverManager;
import java.sql.*;

public class Example2 {
     Example2()
    {
         try
         {
              Class.forName("com.mysql.jdbc.Driver");
              //create connection object
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ronak?createDatabaseIfNotExist=true?" +
                      "user=root&password=991115");
              //create PreparedStatement object
              PreparedStatement ps=con.prepareStatement("create table Student(stdId int primary key,studName VARCHAR(30) not null )");
              //execute the sql query
              int count=ps.executeUpdate();//returns 0
              //System.out.println(count);
              System.out.println("Table created successfully!!");
         }
         catch (Exception e)
         {
              e.printStackTrace();
         }
    }
    public static void main(String s[])
    {
         new Example2();
    }

}
