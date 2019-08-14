package com.yedam.app.service.impl;

import java.sql.Connection;
import java.util.List;

import com.yedam.app.common.DAO;
import com.yedam.app.model.Admin;
import com.yedam.app.model.GroupService;
import com.yedam.app.model.Group_Subject;

public class GroupServiceImpl implements GroupService
{

	GroupDAO groupDAO = new GroupDAO();

	private static GroupServiceImpl instance = new GroupServiceImpl();
	public GroupServiceImpl getInstance() {		
		return instance;
	}
	
	public List<Group_Subject> list() 
	{
		
		Connection conn = DAO.getConnect();
		List<Group_Subject> list = null;
		try {
			list = groupDAO.selectAll(conn);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;	
		
	}

}
