package com.vastika.jdbc_demo.usingst;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.vastika.jdbc_demo.util.DbUtil;

public class TableCreateDemo {

 static final String SQL ="create table demo_tbl(id int not null auto_increment, demo_name varchar (50), primary key(id))";;
	
	public static void main(String[] args) {
		
		try(
				Connection con = DbUtil.getConnection();
				Statement st =con.createStatement();
				){
			st.executeUpdate(SQL);
			System.out.println("Table Create");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
