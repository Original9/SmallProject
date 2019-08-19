package com.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;
import com.yedam.app.model.Register_Subject;

public class RegisterDAO 
{
	public ArrayList<Register_Subject> selectAll() throws SQLException
	{
		Connection conn = DAO.getConnect();
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
	
	public void insert_register_subject(Register_Subject register_subject)
	{ // subject_code is foreign key from subject now, so not able to overlap code key if i connected other std_id.
		// 
		Connection conn = DAO.getConnect();
		
		String sql = "insert into register_subject_class values(?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, register_subject.getSubject_code());
			pstmt.setString(2, register_subject.getStd_id());
			pstmt.setString(3, register_subject.getRegister_date());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void init_register_subject()
	{
		Connection conn = DAO.getConnect();
		
		String sql = "truncate table register_subject_class"; // 테이블을 선택해서 초기화 가능한지 확인 
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			System.out.println("수강신청하기 전에 초기화");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete_register_subject(String delete_code)
	{
		Connection conn = DAO.getConnect();
		String sql = "delete from register_subject_class  where subject_code = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, delete_code);
			pstmt.executeUpdate();
			System.out.println("한건 삭제!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
