package com.yedam.app.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.security.auth.kerberos.KerberosKey;

import com.yedam.app.common.DAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@FXML
	private Label lblStatus;

	@FXML
	private TextField txtUserName;
	@FXML
	private TextField txtPassword;


	// 수강신청 창으로 학생정보를 넘기기 위한 변수
	public static String connectId;

	public void setConn_info(String newValue) {
		connectId = newValue;
	}

	public static String getConn_info() {
		return connectId;
	}
	////////////////////

	////////////////////
	class LoginInfo {
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

	public ArrayList<LoginInfo> CheckIndentity() {
		Connection conn = DAO.getConnect();
		LoginInfo temp = null;
		ArrayList<LoginInfo> list = new ArrayList<>();

		String sql = "select to_char(std_id) id ,passwd, 's' user_type from student_info \r\n" + "union \r\n"
				+ "select admin_id, admin_pawd, 'a' from admin";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
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

	public void Login(ActionEvent event) throws Exception {

		ArrayList<LoginInfo> loginList = CheckIndentity();

		for (LoginInfo lg : loginList) {
			if (txtUserName.getText().equals(lg.getId()) && lg.getId().length() == 8) {
				if (txtPassword.getText().equals(lg.getPasswd())) {
					setConn_info(lg.getId());
					lblStatus.setText("Login Success");
					try {
						rootLayout = FXMLLoader.load(getClass().getResource("root.fxml"));
						Scene scene = new Scene(rootLayout, 850, 900);
						primaryStage = (Stage) txtUserName.getScene().getWindow(); // statge 
						primaryStage.setTitle("SubjectApply");
						AnchorPane subjectview = FXMLLoader.load(getClass().getResource("SubjectApply.fxml"));
						rootLayout.setCenter(subjectview);
						primaryStage.setScene(scene);
						primaryStage.show();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			} else if (txtUserName.getText().equals(lg.getId())) {
				if (txtPassword.getText().equals(lg.getPasswd())) {
					setConn_info(lg.getId());
					lblStatus.setText("Login Success");
					try {
						rootLayout = FXMLLoader.load(getClass().getResource("root.fxml"));
						Scene scene = new Scene(rootLayout, 850, 900);
						primaryStage = (Stage) txtUserName.getScene().getWindow();
						primaryStage.setTitle("Administrator");
						AnchorPane adminview = FXMLLoader.load(getClass().getResource("Administrator.fxml"));
						rootLayout.setCenter(adminview);
						primaryStage.setScene(scene);
						primaryStage.show();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			} else {
				lblStatus.setText("Login Failed");
			}

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	public void handleEnterkey(KeyEvent event) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}


