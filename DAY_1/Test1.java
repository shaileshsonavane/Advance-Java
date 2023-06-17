package com.demo.mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
public class Test1 {

	public static void main(String[] args) {
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
			// 4. Execute query
			ResultSet st= sr.executeQuery("select * from emp");
			while(st.next())
			{
				System.out.println("ID :"+st.getInt(1)+", Name :"+ st.getString(2)+",Salary :"+st.getString(7));
		
			}
			
			// create new table
			String sql = "create table registration" +
			 "(id INTEGER not NULL, " + " firstName VARCHAR(100), " + 
             " lastLast VARCHAR(100), " + " age INTEGER, " + " PRIMARY KEY ( id ))"; 
			int don=sr.executeUpdate(sql);
			System.out.println(don);
			System.out.println("Create table...");
			
		}catch (SQLException e) {
		
			System.out.println(e.getMessage());
		}
  
	}

	
}
