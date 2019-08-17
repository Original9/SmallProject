package com.yedam.app.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;
import com.yedam.app.model.RegisterService;
import com.yedam.app.model.Register_Subject;

public class RegisterServiceImpl implements RegisterService
{
	RegisterDAO registerDAO = new RegisterDAO();
	private static RegisterServiceImpl instance = new RegisterServiceImpl();
	public RegisterServiceImpl getInstance()
	{
		return instance;
	}

	@Override
	public ArrayList<Register_Subject> ResiterOfList() {
		Connection conn = DAO.getConnect();
		ArrayList<Register_Subject> list = null;
		try {
			list = registerDAO.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}finally {
			DAO.close(conn);
		}
		
		return null;
	}

	@Override
	public void updateRegister(Connection conn, int sub_code) {
		
	}

	@Override
	public void deleteRegister(Connection conn, int sub_code) {
		
	}

}
