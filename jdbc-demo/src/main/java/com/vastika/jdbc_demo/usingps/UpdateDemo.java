package com.vastika.jdbc_demo.usingps;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.vastika.jdbc_demo.util.DbUtil;

public class UpdateDemo {
public static final String SQL ="update demo_tbl set demo_name=?, age=?, mobile_no=?, dob=? where id=?";
	
	
	public static void main(String[] args) {
		
		try(
				PreparedStatement ps =DbUtil.getConnection().prepareStatement(SQL);
				){
			ps.setString(1,"helloDemo1");
			ps.setInt(2, 33);
			ps.setLong(3, 99998787);
			ps.setDate(4, new Date(100000000));
			ps.setInt(5, 1);
			ps.executeUpdate();
			
			System.out.println("Data Update");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
