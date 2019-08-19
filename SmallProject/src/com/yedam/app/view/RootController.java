package com.yedam.app.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootController implements Initializable {
	private AnchorPane rootLayout;
	private Stage primaryStage;
	
	@FXML
	MenuBar menuBar;
	@FXML
	BorderPane borderPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void handleExit(ActionEvent actionEvent) {
		System.exit(0);
	}

	@FXML
	public void handleHelp(ActionEvent actionEvent) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Program Information");
		alert.setHeaderText("수강신청 도움말");
		alert.setContentText("자기의 일은 스스로하자");
		alert.show();
	}

	@FXML
	public void handlelogout(ActionEvent actionEvent) {
		try {
//			AnchorPane loginview = FXMLLoader.load(getClass().getResource("Login.fxml"));
//			borderPane.setCenter(loginview);
			rootLayout = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(rootLayout);
			primaryStage = (Stage) menuBar.getScene().getWindow();
			primaryStage.setTitle("Login");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handlePageAdministrator(ActionEvent actionEvent) {
		try {
			AnchorPane adminview = FXMLLoader.load(getClass().getResource("Administrator.fxml"));
			borderPane.setCenter(adminview);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handlePageSubject(ActionEvent actionEvent) {
		try {
			BorderPane subjectview = FXMLLoader.load(getClass().getResource("SubjectApply.fxml"));
			borderPane.setCenter(subjectview);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handlePageTime(ActionEvent actionEvent) {
		try {
			AnchorPane timeview = FXMLLoader.load(getClass().getResource("TimeTable.fxml"));
			borderPane.setCenter(timeview);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
