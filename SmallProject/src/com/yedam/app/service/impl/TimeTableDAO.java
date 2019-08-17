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
