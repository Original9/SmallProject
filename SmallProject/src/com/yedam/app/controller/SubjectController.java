package com.yedam.app.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.yedam.app.Observable.Ob_subject;
import com.yedam.app.model.Subject;
import com.yedam.app.service.impl.SubjectDAO;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.*;

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
	
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		colSubject_code.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_code"));
		colSubject_name.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_name"));		
		colSubject_explain.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_explain"));
		colSubject_group_code.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("suject_group_code"));		
		colSubject_start_day.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("suject_start_day"));
		colSubject_end_day.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_day"));
		colSubject_start_time.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_start_time"));
		colSubject_end_time.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_time"));
		colSubject_y_s.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_y_s"));
		colClass_point.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("class_point"));
		colGrade.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("grade"));
		
	}

}
