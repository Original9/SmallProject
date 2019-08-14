package com.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

import com.yedam.app.model.StdService;
import com.yedam.app.model.Students;

public class StdDAO 
{	
	
	public Students selectOne(Connection conn, int stdId)
	{
		Students temp_students = null;
		String sql = "select * from student_info where std_id = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stdId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				temp_students = new Students();
				temp_students.setStd_id(rs.getInt("std_id"));
				temp_students.setLastName(rs.getString("last_name"));
				temp_students.setFirstName(rs.getString("first_name"));
				temp_students.setMajor(rs.getString("major"));
				temp_students.setPhoneNum(rs.getString("phone_num"));
				temp_students.setPasswd(rs.getString("passwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return temp_students;
	}
	
	
	
	public void insertStd(Connection conn, Students std) throws SQLException
	{
		//1.connect 2. 구문 3. 파라미터 셋팅 4. 실행 5. 연결해제
		
		//1.connect
		
		//2. 구문
		String sql = "insert into student_info values(?,?,?,?,?,?)";			
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//3.파라미터 셋팅
		pstmt.setInt(1, std.getStd_id());
		pstmt.setString(2, std.getLastName());
		pstmt.setString(3, std.getFirstName());
		pstmt.setString(4, std.getPhoneNum());
		pstmt.setString(5, std.getMajor());
		pstmt.setString(6, std.getPasswd());
		
		//4.실행
		int r = pstmt.executeUpdate();
		System.out.println(r +"건이 처리되었습니다.");
	}

	
	public void updateStd(Connection conn, Students std) 
	{
		// 나중에 구현 아직 필요하지않음
	}

	
	public void deleteStd(Connection conn, int stdId) throws SQLException 
	{
		String sql = "delete from student_info where std_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, stdId);
		int r = pstmt.executeUpdate();
		System.out.println(r+"건이 업데이트 되었습니다.");		
	}
	
	public ArrayList<Students> selectAll() throws SQLException 
	{
		Connection conn = DAO.getConnect();
		Students temp_students = null;
		ArrayList<Students> list = new ArrayList<>();
		//1.connect 2. 구문 3. 파라미터 셋팅 4. 실행 5. 연결해제
		
			//2. 구문
			String sql = "select * from student_info order by 1";			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//3.파라미터 셋팅
			
			//4.실행
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp_students = new Students();
				temp_students.setStd_id(rs.getInt("std_id"));
				temp_students.setLastName(rs.getString("last_name"));
				temp_students.setFirstName(rs.getString("first_name"));
				temp_students.setMajor(rs.getString("major"));
				temp_students.setPhoneNum(rs.getString("phone_num"));
				temp_students.setPasswd(rs.getString("passwd"));
				list.add(temp_students);
			}			

			return list;
			
	}

}
