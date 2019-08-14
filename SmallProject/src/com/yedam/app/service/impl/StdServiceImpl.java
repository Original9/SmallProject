package com.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.yedam.app.common.DAO;

import com.yedam.app.model.StdService;
import com.yedam.app.model.Students;

public class StdServiceImpl implements StdService 
{
	StdDAO stdDAO = new StdDAO();

	private static StdServiceImpl instance = new StdServiceImpl();
	public StdService getInstance() {		
		return instance;
	}

	@Override
	public List<Students> selectAll() {
		Connection conn = DAO.getConnect();
		List<Students> list = null;
		try {
			list = stdDAO.selectAll();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
		
	}

	@Override
	public boolean insertStd(Students std) 
	{
		Connection conn = DAO.getConnect();
		try {			
			conn.setAutoCommit(false);
			//부서가 있는지 확인
			Students deptResult = stdDAO.selectOne(conn, std.getStd_id());
			if(deptResult != null) {
				System.out.println("이미 있는 아이디입니다.");
				return false;
			}
			
			//부서 등록
			stdDAO.insertStd(conn, std);
			
			
			//커밋
			conn.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
			//롤백
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DAO.close(conn);
		}
		return true;		
		
	}

	@Override
	public void updateStd(Connection conn, int stdId) 
	{
		
	}

	@Override
	public void deleteStd(Connection conn, int stdId) {
		try {
			stdDAO.deleteStd(conn,stdId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Students selectOne(int stdId) {
		Connection conn = DAO.getConnect();
		try {
			return stdDAO.selectOne(conn, stdId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DAO.close(conn);
		}
	}

}
