package com.yedam.app.Observable;

import javafx.beans.property.SimpleStringProperty;

public class Ob_register 
{
	public SimpleStringProperty suject_code = new SimpleStringProperty();
	public SimpleStringProperty std_id = new SimpleStringProperty();
	public SimpleStringProperty register_date = new SimpleStringProperty();
	public SimpleStringProperty getSuject_code() {
		return suject_code;
	}
	public SimpleStringProperty getStd_id() {
		return std_id;
	}
	public SimpleStringProperty getRegister_date() {
		return register_date;
	}
	
	 

}
