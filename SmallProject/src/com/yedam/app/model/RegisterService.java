package com.yedam.app.model;

import java.sql.Connection;
import java.util.List;

public interface RegisterService 
{
	//등록되어있는 과목들 리스트
	public List<Register_Subject> ResiterOfList();
	//과목 코드 받아서 수강신청 목록테이블에 넣기 
	public void updateRegister(Connection conn, int sub_code);
	//수강신청 목록에서 삭제
	public void deleteRegister(Connection conn, int sub_code);
	
}
