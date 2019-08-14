package com.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.model.Admin;

public class AdminDAO
{
	public List<Admin> selectAll(Connection conn) throws SQLException 
	{
		Admin temp_admin = null;
		List<Admin> list = new ArrayList<>();
		//1.connect 2. 구문 3. 파라미터 셋팅 4. 실행 5. 연결해제
		
			//2. 구문
			String sql = "select * from admin order by 1";			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.파라미터 셋팅
			
			//4.실행
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp_admin = new Admin();
				temp_admin.setAdminNum(rs.getInt("admin_num"));
				temp_admin.setAdmin_id(rs.getString("admin_id"));
				temp_admin.setAdminPw(rs.getString("admin_pawd"));
				
				list.add(temp_admin);
			}			

			return list;
			
	}

}
