package com.yedam.app.model;

public class Professor 
{
	private String pro_id;
	private String firstName;
	private String lastName;
	private String phonNum;
	private String passPw;
	private String major;
	
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
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
	public String getPhonNum() {
		return phonNum;
	}
	public void setPhonNum(String phonNum) {
		this.phonNum = phonNum;
	}
	public String getPassPw() {
		return passPw;
	}
	public void setPassPw(String passPw) {
		this.passPw = passPw;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "Professor [pro_id=" + pro_id + ", firstName=" + firstName + ", lastName=" + lastName + ", phonNum="
				+ phonNum + ", passWd=" + passPw + ", major=" + major + "]";
	}
	
	

}
