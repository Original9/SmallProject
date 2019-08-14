package com.yedam.app.Observable;

import javafx.beans.property.SimpleStringProperty;

public class Ob_std 
{
	public SimpleStringProperty std_id = new SimpleStringProperty();
	public SimpleStringProperty first_name =new SimpleStringProperty();
	public SimpleStringProperty last_name = new SimpleStringProperty();
	public SimpleStringProperty phone_num = new SimpleStringProperty();
	public SimpleStringProperty major = new SimpleStringProperty();
	public SimpleStringProperty passwd = new SimpleStringProperty();
	
	
	
	public SimpleStringProperty getStd_id() {
		return std_id;
	}
	
	public SimpleStringProperty getFirst_name() {
		return first_name;
	}
	
	public SimpleStringProperty getLast_name() {
		return last_name;
	}
	
	public SimpleStringProperty getPhone_num() {
		return phone_num;
	}
	
	public SimpleStringProperty getMajor() {
		return major;
	}
	
	public SimpleStringProperty getPasswd() {
		return passwd;
	}
	
	
}


