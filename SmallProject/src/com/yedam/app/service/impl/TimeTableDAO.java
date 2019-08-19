package com.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yedam.app.common.DAO;
import com.yedam.app.model.Subject;
import com.yedam.app.model.TimeTable;


public class TimeTableDAO 
{
	public void updateTimeTable(ArrayList<TimeTable> list)
	{
		Connection conn =  DAO.getConnect();
		
		for(int i = 0 ; i<list.size() ; i++)
		{
			
			if(list.get(i).getMonday() != null)
			{				
				String sql = null;
				if(i == 0)
				{					
					//update 9시 월요일 
					sql = "update time_table set monday = ? where start_time = '9:00'";					
				}
				if(i == 1)
				{
					//update 11시 월요일					
					sql = "update time_table set monday = ? where start_time = '11:00'";
				}
				if(i == 2)
				{
					//update 13시 월요일					
					sql = "update time_table set monday = ? where start_time = '13:00'";					
				}
				if(i == 3)
				{
					//update 15시 월요일
					sql = "update time_table set monday = ? where start_time = '15:00'";
				}
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, list.get(i).getMonday());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(list.get(i).getTuseday() != null)
			{
				String sql = null;
				if(i == 0)
				{					
					//update 9시 화요일 
					sql = "update time_table set tuesday = ? where start_time = '9:00'";					
				}
				if(i == 1)
				{
					//update 11시 화요일
					
					sql = "update time_table set tuesday = ? where start_time = '11:00'";
				}
				if(i == 2)
				{
					//update 13시 화요일					
					sql = "update time_table set tuesday = ? where start_time = '13:00'";					
				}
				if(i == 3)
				{
					//update 15시 화요일
					sql = "update time_table set tuesday = ? where start_time = '15:00'";
				}
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, list.get(i).getTuseday());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(list.get(i).getWednesday() != null)
			{
				//update
				String sql = null;
				if(i == 0)
				{					
					//update 9시 화요일 
					sql = "update time_table set wednesday = ? where start_time = '9:00'";					
				}
				if(i == 1)
				{
					//update 11시 화요일
					sql = "update time_table set wednesday = ? where start_time = '11:00'";
				}
				if(i == 2)
				{
					//update 13시 화요일					
					sql = "update time_table set wednesday = ? where start_time = '13:00'";					
				}
				if(i == 3)
				{
					//update 15시 화요일
					sql = "update time_table set wednesday = ? where start_time = '15:00'";
				}
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, list.get(i).getWednesday());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(list.get(i).getThursday() != null)
			{
				String sql = null;
				if(i == 0)
				{					
					//update 9시 화요일 
					sql = "update time_table set thursday = ? where start_time = '9:00'";					
				}
				if(i == 1)
				{
					//update 11시 화요일
					sql = "update time_table set thursday = ? where start_time = '11:00'";
				}
				if(i == 2)
				{
					//update 13시 화요일					
					sql = "update time_table set thursday = ? where start_time = '13:00'";					
				}
				if(i == 3)
				{
					//update 15시 화요일
					sql = "update time_table set thursday = ? where start_time = '15:00'";
				}
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, list.get(i).getThursday());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(list.get(i).getFriday() != null)
			{
				String sql = null;
				if(i == 0)
				{					
					//update 9시 화요일 
					sql = "update time_table set friday = ? where start_time = '9:00'";					
				}
				if(i == 1)
				{
					//update 11시 화요일
					sql = "update time_table set friday = ? where start_time = '11:00'";
				}
				if(i == 2)
				{
					//update 13시 화요일					
					sql = "update time_table set friday = ? where start_time = '13:00'";					
				}
				if(i == 3)
				{
					//update 15시 화요일
					sql = "update time_table set frisday = ? where start_time = '15:00'";
				}
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, list.get(i).getFriday());
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		
	}
	
	public ArrayList<TimeTable> selectAll() throws SQLException
	{
		Connection conn = DAO.getConnect();
		TimeTable temp_timetable = null;
		ArrayList<TimeTable> list = new ArrayList<>();
		String sql = "select * from time_table";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			temp_timetable = new TimeTable();
			temp_timetable.setStart_time(rs.getString("start_time"));
			temp_timetable.setEnd_time(rs.getString("end_time"));
			//System.out.println(temp_timetable);
			
			list.add(temp_timetable);
		}
		rs.close();
		return list;
	}
	
	public void updateTimetable(Connection conn, TimeTable timetable) throws SQLException
	{
		//1.connect 2. 구문 3. 파라미터 셋팅 4. 실행 5. 연결해제
		
		//1.connect
		
		//2. 구문
		String sql = "update time_talbe set suject_name = ? subject_day = ? where start_time = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//3.파라미터 셋팅
		
		//4.실행
		int r = pstmt.executeUpdate();
		System.out.println(r +"건이 처리되었습니다.");
	}

}
