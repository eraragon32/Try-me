package com.vastika.jdbc_demo.usingst;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.vastika.jdbc_demo.util.DbUtil;

public class DeleteDemo {


		public static final String SQL ="delete from demo_tbl where id=3";
		
		
		public static void main(String[] args) {
			
			try(
					Connection con =DbUtil.getConnection();
					Statement st =con.createStatement();
					){
				st.executeUpdate(SQL);
				System.out.println("Data Deleted");
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


