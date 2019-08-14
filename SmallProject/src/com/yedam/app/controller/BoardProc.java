package com.yedam.app.controller;

import java.util.List;
import java.util.Scanner;

import javax.xml.ws.Service;

import com.yedam.app.model.Students;
import com.yedam.app.service.impl.StdServiceImpl;



public class BoardProc
{
	Scanner sc = new Scanner(System.in);
	StdServiceImpl service = new StdServiceImpl();
	
	public void execute()
	{		
		
		StdServiceImpl service = new StdServiceImpl();
		System.out.println("===================※계시판※========================");
		List<Students> list = service.selectAll();
		for(Students bf : list)
		{		
			System.out.println(bf);
		}
		
		System.out.println("*************************************************");
		System.out.println("1)글쓰기 2)글삭제하기 3)전체 글 보기 ");
		System.out.println("*************************************************");
		System.out.println("메뉴입력: ");
		int menu = sc.nextInt();
		if(menu == 1)
		{
			// insert 
			Students std = new Students();
			std.setFirstName("a");
			std.setLastName("a");
			std.setMajor("a");
			std.setPasswd("1234");
			std.setPhoneNum("12344322");
			std.setStd_id(33333333);
			service.insertStd(std);
		}
		else if(menu == 2 )
		{			
			//delete 랑 확인
		}
		else if(menu ==3)
		{
			list = service.selectAll();
			for(Students bf : list)
			{		
				System.out.println(bf);
			}
		}
	}
	
	

}
