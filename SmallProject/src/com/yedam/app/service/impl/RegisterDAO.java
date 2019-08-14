package com.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.model.Register_Subject;

public class RegisterDAO 
{
	public List<Register_Subject> selectAll(Connection conn) throws SQLException
	{
		Register_Subject temp_r = null;
		ArrayList<Register_Subject> list = new ArrayList<>();
		String sql = "select * from register_subject_class";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			temp_r = new Register_Subject();
			temp_r.setSubject_code(rs.getString("subject_code"));
			temp_r.setStd_id(rs.getString("std_id"));
			temp_r.setRegister_date(rs.getString("register_date"));
			
			list.add(temp_r);
			
		}
		
		
		
		
		return list;
	}


}
