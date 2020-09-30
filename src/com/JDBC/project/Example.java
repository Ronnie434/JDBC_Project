package com.JDBC.project;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class Example {
	

	public static void main(String[] args) {
		try {
			//Load Driver & Driver Manager
			Class.forName("com.mysql.jdbc.Driver");
			
			//Create connection
			
			Connection Cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Ronak2?createDatabaseIfNotExist=true" +
                    "user=root&password=991115");
			//Create statement
			
			Statement st =Cn.createStatement();
			ResultSet rs =st.executeQuery("Select * from employee");
			
			while(rs.next())
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getInt(4));
			
			System.out.println("Enter the Name:");
			Scanner sn = new Scanner(System.in);
			String Name=sn.nextLine();
			System.out.println("Enter the department:");
			String  Department=sn.nextLine();
			System.out.println("Enter the Salary:");
			double Salary = sn.nextDouble();
			System.out.println("Enter the Age:");
			int Age = sn.nextInt();
			
			int rv =st.executeUpdate("insert into Employee values('"+Name+"', '"+Department+"', "+Salary+" ,"+Age+")");
			
			
			Cn.close();
			
		}
		catch(Exception Ex){
			System.out.println(Ex);
		}

	}

}
