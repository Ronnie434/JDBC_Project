package com.JDBC.project;

import java.sql.*;
class Example4
{
     public static final String DBURL = "jdbc:mysql://localhost/ronak";
     public static final String DBUSER = "root";
     public static final String DBPASS = "991115";
     public static void main(String args[])
     {
          try
          {
               //Loading the driver
               Class.forName("com.mysql.jdbc.Driver");
               //Cretae the connection object
               Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
               //Insert the record
               String sql = "INSERT INTO emp (emp_id, empname, email, city) VALUES (?, ?, ?, ?)";
               PreparedStatement statement = con.prepareStatement(sql);
               statement.setInt(1, 100);
               statement.setString(2, "Prashant");
               statement.setString(3, "prasant@saxena.com");
               statement.setString(4, "Pune");

               int rowsInserted = statement.executeUpdate();
               if (rowsInserted > 0)
               {
                    System.out.println("A new employee was inserted successfully!\n");
               }
               // Display the record
               String sql1 = "SELECT * FROM Emp";
               Statement stmt = con.createStatement();
               ResultSet result = stmt.executeQuery(sql1);

               while (result.next())
               {
                    System.out.println (result.getInt(1)+" "+
                    result.getString(2)+" "+
                    result.getString(3)+" "+
                    result.getString(4));
               }

               //Update the record
               String sql2 = "Update Emp set email = ? where empname = ?";
               PreparedStatement pstmt = con.prepareStatement(sql2);
               pstmt.setString(1, "Jaya@gmail.com");
               pstmt.setString(2, "Jaya");
               int rowUpdate = pstmt.executeUpdate();
               if (rowUpdate > 0)
               {
                    System.out.println("\nRecord updated successfully!!\n");
               }

               //Delete the record
           /*    String sql3 = "DELETE FROM Emp WHERE empname=?";
               PreparedStatement statement1 = con.prepareStatement(sql3);
               statement1.setString(1, "Prashant");
               int rowsDeleted = statement1.executeUpdate();
               if (rowsDeleted > 0)
               {
                    System.out.println("A Employee was deleted successfully!\n");
               }*/
          } 
          catch(Exception ex)
          {
               ex.printStackTrace();
          }
     }

}
