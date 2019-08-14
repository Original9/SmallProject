package com.yedam.app.service.impl;


import java.sql.Connection;
import java.util.List;

import com.yedam.app.common.DAO;
import com.yedam.app.model.Admin;
import com.yedam.app.model.AdminService;
import com.yedam.app.model.StdService;
import com.yedam.app.model.Students;

public class AdminServiceImpl implements AdminService
{

	AdminDAO admDAO = new AdminDAO();

	private static AdminServiceImpl instance = new AdminServiceImpl();
	public AdminService getInstance() {		
		return instance;
	}
	@Override
	public Admin selectOne(int admin_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> selectAll() {
		Connection conn = DAO.getConnect();
		List<Admin> list = null;
		try {
			list = admDAO.selectAll(conn);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;	
		}

	@Override
	public boolean insertStd(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateStd(Connection conn, int admin_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStd(Connection conn, int admin_num) {
		// TODO Auto-generated method stub
		
	}

}
