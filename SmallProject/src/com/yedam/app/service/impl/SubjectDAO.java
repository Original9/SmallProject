package com.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;
import com.yedam.app.model.Students;
import com.yedam.app.model.Subject;



public class SubjectDAO 
{
	public void insertStd(Connection conn, Subject sub) throws SQLException
	{
		//1.connect 2. 구문 3. 파라미터 셋팅 4. 실행 5. 연결해제
		
		//1.connect
		
		//2. 구문
		String sql = "insert into subject values(?,?,?,?,?,?,?,?,?,?,?)";			
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//3.파라미터 셋팅
		pstmt.setString(1, sub.getSubject_code());
		pstmt.setString(2, sub.getSubject_name());
		pstmt.setString(3, sub.getSubject_explain());
		pstmt.setString(4, sub.getSubject_group_code());
		pstmt.setString(5, sub.getSubject_start_day());
		pstmt.setString(6, sub.getSubject_end_day());
		pstmt.setString(7, sub.getSubject_start_time());
		pstmt.setString(8, sub.getSubject_end_time());
		pstmt.setString(9, sub.getSubject_y_s());
		pstmt.setString(10, sub.getClass_point());
		pstmt.setString(11, sub.getGrade());
		
		
		//4.실행
		int r = pstmt.executeUpdate();
		System.out.println(r +"건이 처리되었습니다.");
	}
	public void deleteSub(Connection conn, int subCode) throws SQLException
	{
		String sql = "delete from subject where subject_code = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, subCode);
		int r = pstmt.executeUpdate();
		System.out.println(r+"건이 삭제되었습니다.");
				
	}
	public Subject selectOne(String subject_code) throws SQLException
	{
		Connection conn = DAO.getConnect();
		Subject temp_subject = null;
		
		//1.connect 2. 구문 3. 파라미터 셋팅 4. 실행 5. 연결해제
		
			//2. 구문
			//String sql = "select subject_code,subject_name,subject_explain,subject_group_code,subject_start_day,subject_end_day,subject_start_time,subject_end_time,class_point,grade from subject order by 1 ";
			String sql = "select * from subject where subject_code = ? order by subject_code";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3.파라미터 셋팅
			pstmt.setString(1, subject_code);
			//4.실행
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				temp_subject = new Subject();				
				temp_subject.setSubject_code(rs.getString("subject_code"));
				temp_subject.setSubject_name(rs.getString("subject_name"));
				temp_subject.setSubject_explain(rs.getString("subject_explain"));
				temp_subject.setSubject_group_code(rs.getString("subject_group_code"));
				temp_subject.setSubject_start_day(rs.getString("subject_start_day"));
				temp_subject.setSubject_end_day(rs.getString("subject_end_day"));
				temp_subject.setSubject_start_time(rs.getString("subject_start_time"));
				temp_subject.setSubject_end_time(rs.getString("subject_end_time"));
				temp_subject.setSubject_y_s(rs.getString("subject_y_s"));
				temp_subject.setClass_point(rs.getString("class_point"));
				temp_subject.setGrade(rs.getString("grade"));
				temp_subject.setSubject_day(rs.getString("subject_day"));
				
				//System.out.println(temp_subject);				
								
			}			
			rs.close();

			
			return temp_subject; 
	}
	
	
	public ArrayList<Subject> selectAll() throws SQLException
	{
		
		Connection conn = DAO.getConnect();
		Subject temp_subject = null;
		ArrayList<Subject> list = new ArrayList<>();
		//1.connect 2. 구문 3. 파라미터 셋팅 4. 실행 5. 연결해제
		
			//2. 구문
			//String sql = "select subject_code,subject_name,subject_explain,subject_group_code,subject_start_day,subject_end_day,subject_start_time,subject_end_time,class_point,grade from subject order by 1";
			String sql = "select * from subject order by subject_code";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//3.파라미터 셋팅
			
			//4.실행
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				temp_subject = new Subject();				
				temp_subject.setSubject_code(rs.getString("subject_code"));
				temp_subject.setSubject_name(rs.getString("subject_name"));
				temp_subject.setSubject_explain(rs.getString("subject_explain"));
				temp_subject.setSubject_group_code(rs.getString("subject_group_code"));
				temp_subject.setSubject_start_day(rs.getString("subject_start_day"));
				temp_subject.setSubject_end_day(rs.getString("subject_end_day"));
				temp_subject.setSubject_start_time(rs.getString("subject_start_time"));
				temp_subject.setSubject_end_time(rs.getString("subject_end_time"));
				temp_subject.setSubject_y_s(rs.getString("subject_y_s"));
				temp_subject.setClass_point(rs.getString("class_point"));
				temp_subject.setGrade(rs.getString("grade"));
				temp_subject.setSubject_day(rs.getString("subject_day"));
				
				//System.out.println(temp_subject);
				list.add(temp_subject);
								
			}			
			rs.close();

			
			return list;	
		
	}
	
	

}
