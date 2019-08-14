package com.yedam.app.model;

import java.util.List;

public interface SubjectService
{
	// 과목 리스트 조회
	public List<Subject> list();
	// 과목 삽입
	public void insertSubject();
	// 과목 삭제 
	public void deleteSubject();

}
