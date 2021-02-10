package com.vastika.jdbc_demo.usingst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreateDemo {

	public static final String URL ="jdbc:mysql://localhost:3306/";
	public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	public static final String USER_NAME="root";
	public static final String PASSWORD="root";
	public static final String SQL ="create database demo_db";
	
	public static void main(String[] args) {
		
		Connection con =null;
		Statement st= null;
		
		try {
			// 1.register driver
			Class.forName(DRIVER_NAME);
			//2.get Connection object
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			//3.get Statement object
			st =con.createStatement();
			//4.execute the query
			st.executeUpdate(SQL);
			System.out.println("DB Created");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//5.close 
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		

	}

}
