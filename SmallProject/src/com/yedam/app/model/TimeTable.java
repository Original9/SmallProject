package com.yedam.app.model;

public class TimeTable 
{
	String Start_time;
	String end_time;
	
	String Monday;
	String Tuseday;
	String Wednesday;
	String Thursday;
	String Friday;
	public String getMonday() {
		return Monday;
	}
	public String getTuseday() {
		return Tuseday;
	}
	public String getWednesday() {
		return Wednesday;
	}
	public String getThursday() {
		return Thursday;
	}
	public String getFriday() {
		return Friday;
	}
	public String getStart_time() {
		return Start_time;
	}
	public void setStart_time(String start_time) {
		Start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setMonday(String monday) {
		Monday = monday;
	}
	public void setTuseday(String tuseday) {
		Tuseday = tuseday;
	}
	public void setWednesday(String wednesday) {
		Wednesday = wednesday;
	}
	public void setThursday(String thursday) {
		Thursday = thursday;
	}
	public void setFriday(String friday) {
		Friday = friday;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	@Override
	public String toString() {
		return "TimeTable [Start_time=" + Start_time + ", end_time=" + end_time + ", Monday=" + Monday + ", Tuseday="
				+ Tuseday + ", Wednesday=" + Wednesday + ", Thursday=" + Thursday + ", Friday=" + Friday + "]";
	}
	
	
	
	
	

}
