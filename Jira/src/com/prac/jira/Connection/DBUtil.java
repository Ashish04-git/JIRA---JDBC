package com.prac.jira.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getConnection() {
		try {
			
			//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			//Create a connection object
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/jira","SQL_Prac","letsprac");
			
//			System.out.println("Connection succesfull");
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
//	public static void main(String args[]) {
//		
//		getConnection();
//	}
}
