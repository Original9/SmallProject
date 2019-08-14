package com.yedam.app.model;

public class Subject 
{
	private String subject_code;
	private String subject_name;
	private String subject_explain;
	private String subject_group_code;
	private String pro_id;
	private String subject_start_day;
	private String subject_end_day;
	private String subject_start_time;
	private String subject_end_time;
	private String subject_y_s;
	private String class_point;
	private String grade;
	public String getSubject_code() {
		return subject_code;
	}
	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_explain() {
		return subject_explain;
	}
	public void setSubject_explain(String subject_explain) {
		this.subject_explain = subject_explain;
	}
	public String getSubject_group_code() {
		return subject_group_code;
	}
	public void setSubject_group_code(String subject_group_code) {
		this.subject_group_code = subject_group_code;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	public String getSubject_start_day() {
		return subject_start_day;
	}
	public void setSubject_start_day(String subject_start_day) {
		this.subject_start_day = subject_start_day;
	}
	public String getSubject_end_day() {
		return subject_end_day;
	}
	public void setSubject_end_day(String subject_end_day) {
		this.subject_end_day = subject_end_day;
	}
	public String getSubject_start_time() {
		return subject_start_time;
	}
	public void setSubject_start_time(String subject_start_time) {
		this.subject_start_time = subject_start_time;
	}
	public String getSubject_end_time() {
		return subject_end_time;
	}
	public void setSubject_end_time(String subject_end_time) {
		this.subject_end_time = subject_end_time;
	}
	public String getSubject_y_s() {
		return subject_y_s;
	}
	public void setSubject_y_s(String subject_y_s) {
		this.subject_y_s = subject_y_s;
	}
	public String getClass_point() {
		return class_point;
	}
	public void setClass_point(String class_point) {
		this.class_point = class_point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Subject [subject_code=" + subject_code + ", subject_name=" + subject_name + ", subject_explain="
				+ subject_explain + ", subject_group_code=" + subject_group_code + ", pro_id=" + pro_id
				+ ", subject_start_day=" + subject_start_day + ", subject_end_day=" + subject_end_day
				+ ", subject_start_time=" + subject_start_time + ", subject_end_time=" + subject_end_time
				+ ", subject_y_s=" + subject_y_s + ", class_point=" + class_point + ", grade=" + grade + "]";
	}
	
	
	

}
