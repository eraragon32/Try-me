package com.vastika.jdbc_demo.usingps;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.vastika.jdbc_demo.util.DbUtil;

public class DeleteDemo {
public static final String SQL ="delete from demo_tbl where id=?";
	
	
	public static void main(String[] args) {
		
		try(
				PreparedStatement ps =DbUtil.getConnection().prepareStatement(SQL);
				){
			ps.setInt(1, 2);
			
			ps.executeUpdate();
			
			System.out.println("Data Deleted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
