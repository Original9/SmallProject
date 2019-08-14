package com.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yedam.app.model.Group_Subject;

public class GroupDAO 
{
	public List<Group_Subject> selectAll(Connection conn) throws SQLException 
	{
		Group_Subject temp_group_subject = null;
		List<Group_Subject> list = new ArrayList<>();
		//1.connect 2. 구문 3. 파라미터 셋팅 4. 실행 5. 연결해제
		
			//2. 구문
			String sql = "select * from group_subject order by 1";			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.파라미터 셋팅
			
			//4.실행
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp_group_subject = new Group_Subject();
				temp_group_subject.setAdmin_num(rs.getString("admin_num"));
				temp_group_subject.setSubject_group_code(rs.getString("subject_group_code"));
				temp_group_subject.setSubject_group_name(rs.getString("subject_group_name"));
				
				list.add(temp_group_subject);
			}			

			return list;
			
	}

}
