package com.vastika.jdbc_demo.usingst;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vastika.jdbc_demo.util.DbUtil;

public class SelectDemo {

	public static final String SQL ="select * from demo_tbl";
	
	
	public static void main(String[] args) {
		
		try( 
				Connection con =DbUtil.getConnection();
				Statement st =con.createStatement();
				){
			ResultSet rs= st.executeQuery(SQL);
		
			while(rs.next()) {
				System.out.println(rs.getString("demo_name"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
