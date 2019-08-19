package com.yedam.app.Observable;

import javafx.beans.property.SimpleStringProperty;

public class Ob_subject 
{
	public SimpleStringProperty suject_code = new SimpleStringProperty();
	public SimpleStringProperty subject_name = new SimpleStringProperty();
	public SimpleStringProperty subject_explain = new SimpleStringProperty();
	public SimpleStringProperty subject_group_code = new SimpleStringProperty();
	public SimpleStringProperty subject_start_day = new SimpleStringProperty();
	public SimpleStringProperty subject_end_day = new SimpleStringProperty();
	public SimpleStringProperty subject_start_time =new SimpleStringProperty();
	public SimpleStringProperty subject_end_time = new SimpleStringProperty();
	public SimpleStringProperty subject_y_s = new SimpleStringProperty();
	public SimpleStringProperty class_point = new SimpleStringProperty();
	public SimpleStringProperty grade = new SimpleStringProperty();
	public SimpleStringProperty subject_day =new SimpleStringProperty();
	
	public SimpleStringProperty getSuject_code() {
		return suject_code;
	}
	public SimpleStringProperty getSubject_day() {
		return subject_day;
	}
	public SimpleStringProperty getSubject_name() {
		return subject_name;
	}
	public SimpleStringProperty getSubject_explain() {
		return subject_explain;
	}
	public SimpleStringProperty getSubject_group_code() {
		return subject_group_code;
	}
	public SimpleStringProperty getSubject_start_day() {
		return subject_start_day;
	}
	public SimpleStringProperty getSubject_end_day() {
		return subject_end_day;
	}
	public SimpleStringProperty getSubject_start_time() {
		return subject_start_time;
	}
	public SimpleStringProperty getSubject_end_time() {
		return subject_end_time;
	}
	public SimpleStringProperty getSubject_y_s() {
		return subject_y_s;
	}
	public SimpleStringProperty getClass_point() {
		return class_point;
	}
	public SimpleStringProperty getGrade() {
		return grade;
	}
	
	   

}
