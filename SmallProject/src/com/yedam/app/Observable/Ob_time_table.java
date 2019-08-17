package com.yedam.app.Observable;

import javafx.beans.property.SimpleStringProperty;

public class Ob_time_table 
{
	public SimpleStringProperty start_time = new SimpleStringProperty();
	public SimpleStringProperty end_time = new SimpleStringProperty();
	public SimpleStringProperty subject_name = new SimpleStringProperty();
	public SimpleStringProperty subject_day = new SimpleStringProperty();
	
	public SimpleStringProperty getStart_time() {
		return start_time;
	}
	
	public SimpleStringProperty getEnd_time() {
		return end_time;
	}

	public SimpleStringProperty getSubject_name() {
		return subject_name;
	}
	
	public SimpleStringProperty getSubject_day() {
		return subject_day;
	}


}
