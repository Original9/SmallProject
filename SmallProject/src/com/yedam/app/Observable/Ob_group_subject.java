package com.yedam.app.Observable;

import javafx.beans.property.SimpleStringProperty;

public class Ob_group_subject 
{
	public SimpleStringProperty subject_group_code = new SimpleStringProperty();
	public SimpleStringProperty subject_group_name = new SimpleStringProperty();
	public SimpleStringProperty admin_num = new SimpleStringProperty();
	
	public SimpleStringProperty getSubject_group_code() {
		return subject_group_code;
	}
	public SimpleStringProperty getSubject_group_name() {
		return subject_group_name;
	}
	public SimpleStringProperty getAdmin_num() {
		return admin_num;
	}
	

	
	
}
