package com.yedam.app.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.yedam.app.Observable.Ob_subject;
import com.yedam.app.common.DAO;
import com.yedam.app.model.Students;
import com.yedam.app.model.Subject;
import com.yedam.app.service.impl.SubjectDAO;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SubjectController implements Initializable 
{
	@FXML private TableView<Subject> tableView;
	
	@FXML private TextField txtSubject_code;
	@FXML private TextField txtSubject_name;
	@FXML private TextField txtSubject_explain;
	@FXML private TextField txtSubject_group_code;
	@FXML private TextField txtSubject_start_day;
	@FXML private TextField txtSubject_end_day;
	@FXML private TextField txtSubject_start_time;
	@FXML private TextField txtSubject_end_time;
	@FXML private TextField txtSubject_y_s;
	@FXML private TextField txtClass_point;
	@FXML private TextField txtGrade;
	
	@FXML private TextField txStd_info;	
	@FXML private Button list;
	
	@FXML TableColumn<Ob_subject, String> colSubject_code;
	@FXML TableColumn<Ob_subject, String> colSubject_name;
	@FXML TableColumn<Ob_subject, String> colSubject_explain;
	@FXML TableColumn<Ob_subject, String> colSubject_group_code;
	@FXML TableColumn<Ob_subject, String> colSubject_start_day;
	@FXML TableColumn<Ob_subject, String> colSubject_end_day;
	@FXML TableColumn<Ob_subject, String> colSubject_start_time;
	@FXML TableColumn<Ob_subject, String> colSubject_end_time;
	@FXML TableColumn<Ob_subject, String> colSubject_y_s;
	@FXML TableColumn<Ob_subject, String> colClass_point;
	@FXML TableColumn<Ob_subject, String> colGrade;
	
	
	
	private Alert alert;
	SubjectDAO subjectDAO = new SubjectDAO();
	
	@FXML
	protected void getListSuject(ActionEvent envent)
	{
		
		try {			
			ArrayList<Subject> list = subjectDAO.selectAll();
			
			tableView.setItems(FXCollections.observableArrayList(list));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ShowStudentInfo();
		colSubject_code.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_code"));
		colSubject_name.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_name"));		
		colSubject_explain.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_explain"));
		colSubject_group_code.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_group_code"));		
		colSubject_start_day.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_start_day"));
		colSubject_end_day.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_day"));
		colSubject_start_time.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_start_time"));
		colSubject_end_time.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_time"));
		colSubject_y_s.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_y_s"));
		colClass_point.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("class_point"));
	//	colGrade.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("grade"));
		
	}

}
