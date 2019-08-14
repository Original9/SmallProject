package com.yedam.app.service.impl;

import java.util.List;


import com.yedam.app.model.Subject;
import com.yedam.app.model.SubjectService;

public class SubjectServiceImpl implements SubjectService 
{
	SubjectDAO subjectDAO = new SubjectDAO();
	
	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	public SubjectService getInstance() {		
		return instance;
	}

	@Override
	public List<Subject> list() {
		return null;
	}

	@Override
	public void insertSubject() {
		
	}

	@Override
	public void deleteSubject() {
		
	}
	
	

}
