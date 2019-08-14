package com.yedam.app.model;

import java.sql.Connection;
import java.util.List;

public interface AdminService 
{
		//관리자단건 조회
		public Admin selectOne(int admin_num);
		//관리자 리스트 조회
		public List<Admin> selectAll();
		//관리자 등록
		public boolean insertStd(Admin admin);
		//관리자 정보 변경
		public void updateStd(Connection conn, int admin_num);
		//관리자 삭제
		public void deleteStd(Connection conn, int admin_num);

}
