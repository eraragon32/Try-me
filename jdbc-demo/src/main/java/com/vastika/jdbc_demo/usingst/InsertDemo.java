package com.vastika.jdbc_demo.usingst;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.vastika.jdbc_demo.util.DbUtil;

public class InsertDemo {

	
	public static final String SQL ="insert into demo_tbl(demo_name)values('demo3')";
	
	
	public static void main(String[] args) {
		
		try(
				Connection con =DbUtil.getConnection();
				Statement st =con.createStatement();
				){
			st.executeUpdate(SQL);
			System.out.println("Data Inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
