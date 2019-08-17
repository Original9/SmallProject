package com.yedam.app.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.yedam.app.Observable.Ob_time_table;
import com.yedam.app.common.DAO;
import com.yedam.app.model.Register_Subject;
import com.yedam.app.model.Students;
import com.yedam.app.model.TimeTable;
import com.yedam.app.service.impl.RegisterDAO;
import com.yedam.app.service.impl.TimeTableDAO;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TimeTableController implements Initializable 
{
	@FXML private TextField txStd_info;
	
	@FXML private TableView<TimeTable> tableView;
	
	@FXML TableColumn<Ob_time_table,String> colstart_time;
	@FXML TableColumn<Ob_time_table,String> colend_time;
	@FXML TableColumn<Ob_time_table,String> colMonday;
	@FXML TableColumn<Ob_time_table,String> colTuesday;
	@FXML TableColumn<Ob_time_table,String> colWednesday;
	@FXML TableColumn<Ob_time_table,String> colThursday;
	@FXML TableColumn<Ob_time_table,String> colFriday;
	
	
	@FXML TableColumn<Ob_time_table,String> colsubject_name;
	@FXML TableColumn<Ob_time_table,String> colsubject_day;
	
	ArrayList<TimeTable> timetable = new ArrayList<>();
	
	
	RegisterDAO registerDAO = new RegisterDAO();
	TimeTableDAO timetableDAO = new TimeTableDAO();

	void ShowStudentInfo()
	{
		Connection conn = DAO.getConnect();
		Students temp_students = null;
		String sql = "select * from student_info where std_id = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			String conn_id = LoginController.getConn_info();
						
			pstmt.setString(1, conn_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				temp_students = new Students();
				temp_students.setStd_id(rs.getInt("std_id"));
				temp_students.setLastName(rs.getString("last_name"));
				temp_students.setFirstName(rs.getString("first_name"));
				temp_students.setMajor(rs.getString("major"));
				temp_students.setPhoneNum(rs.getString("phone_num"));
				temp_students.setPasswd(rs.getString("passwd"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		txStd_info.setText("학번: "+String.valueOf(temp_students.getStd_id())+
				" 성: "+temp_students.getLastName()+" 이름: "+temp_students.getFirstName()
				+" 전공: "+temp_students.getMajor());
		
		
	}
	
	@FXML
	protected void getListSubject()
	{ // 굳이 디비에 접속해서 time table만들어서 저장해서 가져올 필요가 없네 
		try {
			//ArrayList<Register_subject> list = registerDAO.selectAll();
			ArrayList<TimeTable> list = timetableDAO.selectAll();
			String day_to_subject_name;			
			
			Connection conn = DAO.getConnect();
			
			String sql = "select a.subject_code, b.std_id,a.subject_day, a.subject_start_time, a.subject_name from subject a, register_subject_class b where a.subject_code = b.subject_code and b.std_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LoginController.getConn_info());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				if(rs.getString("subject_start_time").equals("9:00") && rs.getString("subject_day").equals("월"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(0).setMonday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("11:00") && rs.getString("subject_day").equals("월"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(1).setMonday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("13:00") && rs.getString("subject_day").equals("월"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(2).setMonday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("15:00") && rs.getString("subject_day").equals("월"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(3).setMonday(day_to_subject_name);
				}
				
				if(rs.getString("subject_start_time").equals("9:00") && rs.getString("subject_day").equals("화"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(0).setTuseday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("11:00") && rs.getString("subject_day").equals("화"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(1).setTuseday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("13:00") && rs.getString("subject_day").equals("화"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(2).setTuseday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("15:00") && rs.getString("subject_day").equals("화"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(3).setTuseday(day_to_subject_name);
				}
				
				if(rs.getString("subject_start_time").equals("9:00") && rs.getString("subject_day").equals("수"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(0).setWednesday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("11:00") && rs.getString("subject_day").equals("수"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(1).setWednesday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("13:00") && rs.getString("subject_day").equals("수"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(2).setWednesday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("15:00") && rs.getString("subject_day").equals("수"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(3).setWednesday(day_to_subject_name);
				}
				
				if(rs.getString("subject_start_time").equals("9:00") && rs.getString("subject_day").equals("목"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(0).setThursday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("11:00") && rs.getString("subject_day").equals("목"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(1).setThursday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("13:00") && rs.getString("subject_day").equals("목"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(2).setThursday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("15:00") && rs.getString("subject_day").equals("목"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(3).setThursday(day_to_subject_name);
				}
				
				if(rs.getString("subject_start_time").equals("9:00") && rs.getString("subject_day").equals("금"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(0).setFriday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("11:00") && rs.getString("subject_day").equals("금"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(1).setFriday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("13:00") && rs.getString("subject_day").equals("금"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(2).setFriday(day_to_subject_name);
				}
				if(rs.getString("subject_start_time").equals("15:00") && rs.getString("subject_day").equals("금"))
				{
					day_to_subject_name = rs.getString("subject_name");
					list.get(3).setFriday(day_to_subject_name);
				}
				
			}
			
			
			for(TimeTable tb : list)
			{
				System.out.println(tb);
			}
			// 이걸 TimeTable에 업데이트해서 빈 시간에 어떤 시간표를 넣을수 있을지 확인하자. 
			
			tableView.setItems(FXCollections.observableArrayList(list));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		ShowStudentInfo();
		colstart_time.setCellValueFactory(new PropertyValueFactory<Ob_time_table,String>("Start_time"));
		colend_time.setCellValueFactory(new PropertyValueFactory<Ob_time_table,String>("End_time"));
		colMonday.setCellValueFactory(new PropertyValueFactory<Ob_time_table,String>("Monday"));
		colTuesday.setCellValueFactory(new PropertyValueFactory<Ob_time_table,String>("Tuseday"));
		colWednesday.setCellValueFactory(new PropertyValueFactory<Ob_time_table,String>("Wednesday"));
		colThursday.setCellValueFactory(new PropertyValueFactory<Ob_time_table,String>("Thursday"));
		colFriday.setCellValueFactory(new PropertyValueFactory<Ob_time_table,String>("Friday"));
		getListSubject();
		
		
	}
	
	
	
}
