package com.vastika.jdbc_demo.usingps;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import com.vastika.jdbc_demo.util.DbUtil;

public class InsertDemo {

public static final String SQL ="insert into demo_tbl(demo_name, age, mobile_no, dob)values(?,?,?,?)";
	
	
	public static void main(String[] args) {
		
		try(
				PreparedStatement ps =DbUtil.getConnection().prepareStatement(SQL);
				){
			ps.setString(1,"demo2");
			ps.setInt(2, 23);
			ps.setLong(3, 8787);
			ps.setDate(4, new Date(2000, 12, 01));
			
			ps.executeUpdate();
			
			System.out.println("Data Inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
