package com.yedam.app.model;

import java.sql.Connection;
import java.util.List;


public interface StdService
{
	//학생 조회
	public Students selectOne(int stdId);
	//학생 전체 리스트 조회
	public List<Students> selectAll();
	//학생등록
	public boolean insertStd(Students std);
	//학생정보변경
	public void updateStd(Connection conn, int stdId);
	//학생정보 삭제
	public void deleteStd(Connection conn, int stdId);
	
	
	
	
	
	
	
}
