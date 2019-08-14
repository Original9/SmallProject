package com.yedam.app.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoginController {

	@FXML
	private Label lblStatus;

	@FXML
	private TextField txtUserName;

	@FXML
	private TextField txtPassword;

	public void Login(ActionEvent event) throws Exception {
		if (txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")) {
			lblStatus.setText("Login Success");
			BorderPane rootLayout = (BorderPane) txtUserName.getScene().getRoot();
			BorderPane subjectview = FXMLLoader.load(getClass().getResource("SubjectApply.fxml"));
			rootLayout.setCenter(subjectview);
		} else if (txtUserName.getText().equals("admin") && txtPassword.getText().equals("pass")) {
			lblStatus.setText("Login Success");
			BorderPane rootLayout = (BorderPane) txtUserName.getScene().getRoot();
			AnchorPane adminview = FXMLLoader.load(getClass().getResource("Administrator.fxml"));
			rootLayout.setCenter(adminview);

		} else {
			lblStatus.setText("Login Failed");
		}
	}

}
