package com.yedam.app.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.yedam.app.Observable.Ob_subject;
import com.yedam.app.Observable.Ob_time_table;
import com.yedam.app.common.DAO;
import com.yedam.app.model.Register_Subject;
import com.yedam.app.model.Students;
import com.yedam.app.model.Subject;
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
	@FXML private TableView<Subject> tableView1_tt;
	
	@FXML TableColumn<Ob_time_table,String> colstart_time;
	@FXML TableColumn<Ob_time_table,String> colend_time;
	@FXML TableColumn<Ob_time_table,String> colMonday;
	@FXML TableColumn<Ob_time_table,String> colTuesday;
	@FXML TableColumn<Ob_time_table,String> colWednesday;
	@FXML TableColumn<Ob_time_table,String> colThursday;
	@FXML TableColumn<Ob_time_table,String> colFriday;
	
	
	@FXML TableColumn<Ob_time_table,String> colsubject_name;
	@FXML TableColumn<Ob_time_table,String> colsubject_day;
	
	@FXML TableColumn<Ob_subject, String> colSubject_code_tt;
	@FXML TableColumn<Ob_subject, String> colSubject_name_tt;
	@FXML TableColumn<Ob_subject, String> colSubject_explain_tt;
	@FXML TableColumn<Ob_subject, String> colSubject_group_code_tt;
	@FXML TableColumn<Ob_subject, String> colSubject_start_day_tt;
	@FXML TableColumn<Ob_subject, String> colSubject_end_day_tt;
	@FXML TableColumn<Ob_subject, String> colSubject_start_time_tt;
	@FXML TableColumn<Ob_subject, String> colSubject_end_time_tt;
	@FXML TableColumn<Ob_subject, String> colSubject_y_s_tt;
	@FXML TableColumn<Ob_subject, String> colClass_point_tt;
	@FXML TableColumn<Ob_subject, String> colGrade_tt;
	@FXML TableColumn<Ob_subject,String> colSubject_day_tt;
	
	
	ArrayList<TimeTable> timetable = new ArrayList<>();
	ArrayList<TimeTable> list = new ArrayList<>();
	
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
			list = timetableDAO.selectAll();
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
			
			timetableDAO.updateTimeTable(list);
			
			for(TimeTable tb : list) // timetable list에 있는 값을 데이터베이스로 업데이트 하자 이거 업데이트하고 비어있는 시간에 들을수 있는 과목을 subject테이블과 조인해서 밑에 view창에 띄우면 끝 
			{
				System.out.println(tb);				
			}
			// 이걸 TimeTable에 업데이트해서 빈 시간에 어떤 시간표를 넣을수 있을지 확인하자.
					
			
			tableView.setItems(FXCollections.observableArrayList(list));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	ArrayList<Subject> applicableList = new ArrayList<>(); // 하나하나 null인값 조회해서 리스트에 넣고 마지막에 viwe에 뿌려준다.
	public void Applicable_subjects()
	{
		Connection conn = DAO.getConnect();		
		Subject temp_subject = null;
		// list에 값이 다 들어가 이있다. 
		for(int i = 0 ; i < list.size() ; i++)// 9 시 부터 시작하는 과목중에 월요일을 가르키고 있다. 
		{			
			if (list.get(i).getMonday() == null) {
				String sql = null;
				if (i == 0) {
					// update 9시 월요일
					sql = "select * from subject where subject_start_time = '9:00' and subject_day = '월'";
				}
				if (i == 1) {
					// update 11시 월요일
					sql = "select * from subject where subject_start_time = '11:00' and subject_day = '월'";
				}
				if (i == 2) {
					// update 13시 월요일
					sql = "select * from subject where subject_start_time = '13:00' and subject_day = '월'";
				}
				if (i == 3) {
					// update 15시 월요일
					sql = "select * from subject where subject_start_time = '15:00' and subject_day = '월'";
				}
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next())
					{
						temp_subject = new Subject();
						temp_subject.setSubject_code(rs.getString("subject_code"));
						temp_subject.setSubject_name(rs.getString("subject_name"));
						temp_subject.setSubject_explain(rs.getString("subject_explain"));
						temp_subject.setSubject_group_code(rs.getString("subject_group_code"));
						temp_subject.setSubject_start_day(rs.getString("subject_start_day"));
						temp_subject.setSubject_end_day(rs.getString("subject_end_day"));
						temp_subject.setSubject_start_time(rs.getString("subject_start_time"));
						temp_subject.setSubject_end_time(rs.getString("subject_end_time"));
						temp_subject.setSubject_y_s(rs.getString("subject_y_s"));
						temp_subject.setClass_point(rs.getString("class_point"));
						temp_subject.setGrade(rs.getString("grade"));
						temp_subject.setSubject_day(rs.getString("subject_day"));						
						applicableList.add(temp_subject);
					}
					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			

			}
			if(list.get(i).getTuseday() == null)
			{
				 
					String sql = null;
					if (i == 0) {
						// update 9시 화요일
						sql = "select * from subject where subject_start_time = '9:00' and subject_day = '화'";
					}
					if (i == 1) {
						// update 11시 화요일
						sql = "select * from subject where subject_start_time = '11:00' and subject_day = '화'";
					}
					if (i == 2) {
						// update 13시 화요일
						sql = "select * from subject where subject_start_time = '13:00' and subject_day = '화'";
					}
					if (i == 3) {
						// update 15시 화요일
						sql = "select * from subject where subject_start_time = '15:00' and subject_day = '화'";
					}
					PreparedStatement pstmt;
					try {
						pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery();
						while (rs.next())
						{
							temp_subject = new Subject();
							temp_subject.setSubject_code(rs.getString("subject_code"));
							temp_subject.setSubject_name(rs.getString("subject_name"));
							temp_subject.setSubject_explain(rs.getString("subject_explain"));
							temp_subject.setSubject_group_code(rs.getString("subject_group_code"));
							temp_subject.setSubject_start_day(rs.getString("subject_start_day"));
							temp_subject.setSubject_end_day(rs.getString("subject_end_day"));
							temp_subject.setSubject_start_time(rs.getString("subject_start_time"));
							temp_subject.setSubject_end_time(rs.getString("subject_end_time"));
							temp_subject.setSubject_y_s(rs.getString("subject_y_s"));
							temp_subject.setClass_point(rs.getString("class_point"));
							temp_subject.setGrade(rs.getString("grade"));
							temp_subject.setSubject_day(rs.getString("subject_day"));						
							applicableList.add(temp_subject);
						}						
						rs.close();

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				
				
			}
			if (list.get(i).getWednesday() == null) {
				String sql = null;
				if (i == 0) {
					// update 9시 수요일
					sql = "select * from subject where subject_start_time = '9:00' and subject_day = '수'";
				}
				if (i == 1) {
					// update 11시 수요일
					sql = "select * from subject where subject_start_time = '11:00' and subject_day = '수'";
				}
				if (i == 2) {
					// update 13시 수요일
					sql = "select * from subject where subject_start_time = '13:00' and subject_day = '수'";
				}
				if (i == 3) {
					// update 15시 수요일
					sql = "select * from subject where subject_start_time = '15:00' and subject_day = '수'";
				}
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next()) {
						temp_subject = new Subject();
						temp_subject.setSubject_code(rs.getString("subject_code"));
						temp_subject.setSubject_name(rs.getString("subject_name"));
						temp_subject.setSubject_explain(rs.getString("subject_explain"));
						temp_subject.setSubject_group_code(rs.getString("subject_group_code"));
						temp_subject.setSubject_start_day(rs.getString("subject_start_day"));
						temp_subject.setSubject_end_day(rs.getString("subject_end_day"));
						temp_subject.setSubject_start_time(rs.getString("subject_start_time"));
						temp_subject.setSubject_end_time(rs.getString("subject_end_time"));
						temp_subject.setSubject_y_s(rs.getString("subject_y_s"));
						temp_subject.setClass_point(rs.getString("class_point"));
						temp_subject.setGrade(rs.getString("grade"));
						temp_subject.setSubject_day(rs.getString("subject_day"));
						applicableList.add(temp_subject);
					}
					
					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			if (list.get(i).getThursday() == null) {
				String sql = null;
				if (i == 0) {
					// update 9시 목요일
					sql = "select * from subject where subject_start_time = '9:00' and subject_day = '목'";
				}
				if (i == 1) {
					// update 11시 목요일
					sql = "select * from subject where subject_start_time = '11:00' and subject_day = '목'";
				}
				if (i == 2) {
					// update 13시 목요일
					sql = "select * from subject where subject_start_time = '13:00' and subject_day = '목'";
				}
				if (i == 3) {
					// update 15시 목요일
					sql = "select * from subject where subject_start_time = '15:00' and subject_day = '목'";
				}
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next())
					{
						temp_subject = new Subject();
						temp_subject.setSubject_code(rs.getString("subject_code"));
						temp_subject.setSubject_name(rs.getString("subject_name"));
						temp_subject.setSubject_explain(rs.getString("subject_explain"));
						temp_subject.setSubject_group_code(rs.getString("subject_group_code"));
						temp_subject.setSubject_start_day(rs.getString("subject_start_day"));
						temp_subject.setSubject_end_day(rs.getString("subject_end_day"));
						temp_subject.setSubject_start_time(rs.getString("subject_start_time"));
						temp_subject.setSubject_end_time(rs.getString("subject_end_time"));
						temp_subject.setSubject_y_s(rs.getString("subject_y_s"));
						temp_subject.setClass_point(rs.getString("class_point"));
						temp_subject.setGrade(rs.getString("grade"));
						temp_subject.setSubject_day(rs.getString("subject_day"));						
						applicableList.add(temp_subject);
					}					
					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			

			}
			
			if (list.get(i).getFriday() == null) {
				String sql = null;
				if (i == 0) {
					// update 9시 금요일
					sql = "select * from subject where subject_start_time = '9:00' and subject_day = '금'";
				}
				if (i == 1) {
					// update 11시 금요일
					sql = "select * from subject where subject_start_time = '11:00' and subject_day = '금'";
				}
				if (i == 2) {
					// update 13시 금요일
					sql = "select * from subject where subject_start_time = '13:00' and subject_day = '금'";
				}
				if (i == 3) {
					// update 15시 금요일
					sql = "select * from subject where subject_start_time = '15:00' and subject_day = '금'";
				}
				PreparedStatement pstmt;
				try {
					pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					while (rs.next())
					{
						temp_subject = new Subject();
						temp_subject.setSubject_code(rs.getString("subject_code"));
						temp_subject.setSubject_name(rs.getString("subject_name"));
						temp_subject.setSubject_explain(rs.getString("subject_explain"));
						temp_subject.setSubject_group_code(rs.getString("subject_group_code"));
						temp_subject.setSubject_start_day(rs.getString("subject_start_day"));
						temp_subject.setSubject_end_day(rs.getString("subject_end_day"));
						temp_subject.setSubject_start_time(rs.getString("subject_start_time"));
						temp_subject.setSubject_end_time(rs.getString("subject_end_time"));
						temp_subject.setSubject_y_s(rs.getString("subject_y_s"));
						temp_subject.setClass_point(rs.getString("class_point"));
						temp_subject.setGrade(rs.getString("grade"));
						temp_subject.setSubject_day(rs.getString("subject_day"));						
						applicableList.add(temp_subject);
					}					
					rs.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			

			}
			
		}
		
		tableView1_tt.setItems(FXCollections.observableArrayList(applicableList));
		
	    
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
		
		
		
		colSubject_code_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_code"));
		colSubject_name_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_name"));		
		colSubject_explain_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_explain"));
		colSubject_group_code_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_group_code"));		
		colSubject_start_day_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_start_day"));
		colSubject_end_day_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_day"));
		colSubject_start_time_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_start_time"));
		colSubject_end_time_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_time"));
		colSubject_y_s_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_y_s"));
		colClass_point_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("class_point"));
		colSubject_day_tt.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_day"));
		Applicable_subjects();
		
		
	}
	
	
	
}
