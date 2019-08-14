package com.yedam.app.model;

public class Group_Subject 
{
	private String subject_group_code;
	private String subject_group_name;
	private String admin_num;
	public String getSubject_group_code() {
		return subject_group_code;
	}
	public void setSubject_group_code(String subject_group_code) {
		this.subject_group_code = subject_group_code;
	}
	public String getSubject_group_name() {
		return subject_group_name;
	}
	public void setSubject_group_name(String subject_group_name) {
		this.subject_group_name = subject_group_name;
	}
	public String getAdmin_num() {
		return admin_num;
	}
	public void setAdmin_num(String admin_num) {
		this.admin_num = admin_num;
	}
	@Override
	public String toString() {
		return "Group_Subject [subject_group_code=" + subject_group_code + ", subject_group_name=" + subject_group_name
				+ ", admin_num=" + admin_num + "]";
	}

}
