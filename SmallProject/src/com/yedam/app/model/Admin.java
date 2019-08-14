package com.yedam.app.model;

public class Admin 
{
	private String admin_id;
	private int adminNum;
	private String adminPw;
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public int getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(int adminNum) {
		this.adminNum = adminNum;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", adminNum=" + adminNum + ", adminPw=" + adminPw + "]";
	}
	

}
