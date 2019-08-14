package com.yedam.app.model;

public class Register_Subject 
{
	private String subject_code;
	private String std_id;
	private String register_date;
	public String getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	@Override
	public String toString() {
		return "Register_Subject [subject_code=" + subject_code + ", std_id=" + std_id + ", register_date="
				+ register_date + "]";
	}
	
	
	

}
