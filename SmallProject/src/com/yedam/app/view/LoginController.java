package com.yedam.app.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yedam.app.common.DAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoginController {

	@FXML private Label lblStatus; 
	
	@FXML private TextField txtUserName;
	@FXML private TextField txtPassword;
	

	// 수강신청 창으로 학생정보를 넘기기 위한 변수
	public static String connectId ;
	public void setConn_info(String newValue)
	{		
		connectId = newValue;
		System.out.println(connectId);
	}
	public static String getConn_info()
	{
		return connectId;
	}
	////////////////////
	
	////////////////////
	class LoginInfo
	{
		String Id;
		String passwd;
		public String getId() {
			return Id;
		}
		public void setId(String id) {
			Id = id;
		}
		public String getPasswd() {
			return passwd;
		}
		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}
		@Override
		public String toString() {
			return "LoginInfo [Id=" + Id + ", passwd=" + passwd + "]";
		}
		
	}
	public ArrayList<LoginInfo> CheckIndentity()
	{
		Connection conn = DAO.getConnect();
		LoginInfo temp = null;
		ArrayList<LoginInfo> list = new ArrayList<>();
		
		String sql = "select to_char(std_id) id ,passwd, 's' user_type from student_info \r\n" + 
				"union \r\n" + 
				"select admin_id, admin_pawd, 'a' from admin";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				temp = new LoginInfo();
				temp.setId(rs.getString("id"));
				temp.setPasswd(rs.getString("passwd"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	 return list;
		
	}
	
	
	public void Login(ActionEvent event) throws Exception 
	{
		
		ArrayList<LoginInfo> loginList = CheckIndentity();
		
		for(LoginInfo lg : loginList)
		{			
			if(txtUserName.getText().equals(lg.getId()) && lg.getId().length() == 8)
			{				
				if(txtPassword.getText().equals(lg.getPasswd()))
				{
					setConn_info(lg.getId());
					lblStatus.setText("Login Success");
					BorderPane rootLayout = (BorderPane) txtUserName.getScene().getRoot();
					BorderPane subjectview = FXMLLoader.load(getClass().getResource("SubjectApply.fxml"));
					rootLayout.setCenter(subjectview);
										
					
					
				}
			}
			else if(txtUserName.getText().equals(lg.getId()))
			{				
				if(txtPassword.getText().equals(lg.getPasswd()))
				{
					setConn_info(lg.getId());
					lblStatus.setText("Login Success");
					BorderPane rootLayout = (BorderPane) txtUserName.getScene().getRoot();
					AnchorPane adminview = FXMLLoader.load(getClass().getResource("Administrator.fxml"));
					rootLayout.setCenter(adminview);
									
				}
			}
			else
			{
				lblStatus.setText("Login Failed");
			}
			
			
			
		}
		
		
		
	}

}
