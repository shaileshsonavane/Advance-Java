package com.demo.mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
public class Test2 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		// TODO Auto-generated method stub
		try{
			//1. register the drive
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.150:3306/dac32";
			
			// 2. get connections
			Connection con=DriverManager.getConnection(url,"dac32","welcome");
			if(con!=null)
			{
				System.out.println("connection done...");
			
			}
			else
			{
				System.out.println("connection not done...");
			}
			// 3. create connection
			
			Statement sr=con.createStatement();
			 
			int choice=0;
			do {
				
				System.out.println("1.show all Student 2.Add  new Student 3.Search by ID "
						+ "4. search by Name 5.delete by id 6.Update Student details");
				
				choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					
				ResultSet rs=sr.executeQuery("select * from student");
			      while(rs.next()) {
			    	  System.out.println("Id : " + rs.getInt(1) + ", Name : " + rs.getString(2) + ", last name: "
								+ rs.getString(3) + ", date of Birth: " + rs.getString(4) + ", Email: "
								+ rs.getString(5));
					}
					break;
				
				}
				
			
				
			}
			
		}catch (SQLException e) {
		
			System.out.println(e.getMessage());
		}
  
	}
}

	