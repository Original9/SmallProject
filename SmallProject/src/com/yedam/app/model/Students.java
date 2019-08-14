package com.yedam.app.model;

public class Students 
{
	private int std_id;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String major;
	private String passwd;
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "Students [std_id=" + std_id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNum="
				+ phoneNum + ", major=" + major + ", passwd=" + passwd + "]";
	}
	
	
	
	
	

}
