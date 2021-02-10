package com.vastika.jdbc_demo.usingps;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.vastika.jdbc_demo.util.DbUtil;

public class SelectDemo {

	
public static final String SQL ="select * from demo_tbl";
	
	
	public static void main(String[] args) {
		
		try( 
				
			PreparedStatement ps =DbUtil.getConnection().prepareStatement(SQL);
				){
			ResultSet rs= ps.executeQuery(SQL);
		
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("demo_name"));
				System.out.println(rs.getInt("age"));
				System.out.println(rs.getInt("mobile_no"));
				System.out.println(rs.getDate("dob"));
				System.out.println("==========================");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
