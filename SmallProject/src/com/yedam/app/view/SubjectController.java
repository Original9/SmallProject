package com.yedam.app.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.yedam.app.Observable.Ob_subject;
import com.yedam.app.common.DAO;
import com.yedam.app.model.Register_Subject;
import com.yedam.app.model.Students;
import com.yedam.app.model.Subject;
import com.yedam.app.service.impl.RegisterDAO;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SubjectController implements Initializable 
{
	@FXML private TableView<Subject> tableView;
	@FXML private TableView<Subject> tableView1;
	
//	@FXML private TextField txtSubject_code;
//	@FXML private TextField txtSubject_name;
//	@FXML private TextField txtSubject_explain;
//	@FXML private TextField txtSubject_group_code;
//	@FXML private TextField txtSubject_start_day;
//	@FXML private TextField txtSubject_end_day;
//	@FXML private TextField txtSubject_start_time;
//	@FXML private TextField txtSubject_end_time;
//	@FXML private TextField txtSubject_y_s;
//	@FXML private TextField txtClass_point;
//	@FXML private TextField txtGrade;
	
	@FXML private TextField txStd_info;	
	@FXML private TextField txtSubject_code_register;
	@FXML private TextField txtSubject_register_delete;
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
	@FXML TableColumn<Ob_subject,String> colSubject_day;
	
	@FXML TableColumn<Ob_subject, String> colSubject_code1;
	@FXML TableColumn<Ob_subject, String> colSubject_name1;
	@FXML TableColumn<Ob_subject, String> colSubject_explain1;
	@FXML TableColumn<Ob_subject, String> colSubject_group_code1;
	@FXML TableColumn<Ob_subject, String> colSubject_start_day1;
	@FXML TableColumn<Ob_subject, String> colSubject_end_day1;
	@FXML TableColumn<Ob_subject, String> colSubject_start_time1;
	@FXML TableColumn<Ob_subject, String> colSubject_end_time1;
	@FXML TableColumn<Ob_subject, String> colSubject_y_s1;
	@FXML TableColumn<Ob_subject, String> colClass_point1;
	@FXML TableColumn<Ob_subject, String> colGrade1;
	@FXML TableColumn<Ob_subject,String> colSubject_day1;
	
	ArrayList<Subject> register_list = new ArrayList<>(); // 나중에 시간 되면 0번째 값을 지정해 놓자 
	
	private Alert alert;
	SubjectDAO subjectDAO = new SubjectDAO();
	RegisterDAO registerDAO = new RegisterDAO();
	
	@FXML
	protected void getInformation1(MouseEvent event)
	{
		if(tableView1.getSelectionModel().getSelectedItem() != null)
		{
			txtSubject_register_delete.setText(tableView1.getSelectionModel().getSelectedItem().getSubject_code());			
		}	
		
	}
	
	@FXML
	protected void delete_register_list(ActionEvent event) 
	{		 		
		String delete_code = txtSubject_register_delete.getText();
		if(delete_code != null)
		{
			for(int i = 0 ; i < register_list.size(); i++)
			{
				if(register_list.get(i).getSubject_code().equals(delete_code))
				{
					register_list.remove(i);
				}
			}
			
		}
		 
		if(register_list == null)
		{
			for(int i = 0 ; i < register_list.size() ; )
			{
				register_list.remove(i);
			}
		}
		tableView1.setItems(FXCollections.observableArrayList(register_list));
		

	}
 
	@FXML 
	protected void init_register_list(ActionEvent event)
	{		
		for(int i = 0 ; i < register_list.size() ; )
		{
			register_list.remove(i);
		}
		//다지워도 오류안남
		tableView1.setItems(FXCollections.observableArrayList(register_list));	
		
	}
	
	@FXML
	protected void getListOfRegisterSubject(ActionEvent event)
	{
		boolean check = true;
		if(txtSubject_code_register.getText() != null)
		{
			String add_value = txtSubject_code_register.getText();			
			try {
								
				Subject subject_temp = subjectDAO.selectOne(add_value);	
				for(int i = 0 ; i< register_list.size();i++)
				{
					if(register_list.get(i).getSubject_day().equals(subject_temp.getSubject_day()) && register_list.get(i).getSubject_start_time().equals(subject_temp.getSubject_start_time()))
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Program Information");
						alert.setHeaderText("경고");
						alert.setContentText("Time overlap! Please Check time! -");
						alert.show();
						check = false;
						break;
					}
					
					if(register_list.get(i).getSubject_code().equals(add_value))
					{
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Program Information");
						alert.setHeaderText("warnning!!");
						alert.setContentText("This subject is already registered!");
						alert.show();
						check = false;
						break;
					}					
				}
				if(check)
				{
					// select one 해서 시간 비교해보고 넣으면 될거 같은데 
					register_list.add(subject_temp);					
				}
				
				
				tableView1.setItems(FXCollections.observableArrayList(register_list));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	@FXML
	protected void add_std_register_list(ActionEvent event)
	{
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

		String str = sd.format(new Date()); // 0000년 00월 00 일 00:00:00 형식으로 얻어옴

		
		for(int i = 0; i < register_list.size(); i++)
		{
			Register_Subject rs = new Register_Subject();
			
			rs.setSubject_code(register_list.get(i).getSubject_code());
			rs.setStd_id(LoginController.connectId);
			rs.setRegister_date(str);
			
			registerDAO.insert_register_subject(rs);
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Program Information");
		alert.setHeaderText("Complete");
		alert.setContentText("수강신청 목록에 등록되었습니다.");
		alert.show();
		
		
	}
	
	@FXML
	protected void getListSuject(ActionEvent event)
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
	
	@FXML
	protected void getInformation(MouseEvent event)
	{
		if(tableView.getSelectionModel().getSelectedItem() != null)
		{
			txtSubject_code_register.setText(tableView.getSelectionModel().getSelectedItem().getSubject_code());			
		}
		

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
		colSubject_day.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_day"));
		
		colSubject_code1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_code"));
		colSubject_name1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_name"));		
		colSubject_explain1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_explain"));
		colSubject_group_code1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_group_code"));		
		colSubject_start_day1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_start_day"));
		colSubject_end_day1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_day"));
		colSubject_start_time1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_start_time"));
		colSubject_end_time1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_time"));
		colSubject_y_s1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_y_s"));
		colClass_point1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("class_point"));
	//	colGrade1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("grade"));
		colSubject_day1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_day"));
		
	}

}
