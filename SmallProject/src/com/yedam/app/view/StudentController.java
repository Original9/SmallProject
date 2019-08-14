package com.yedam.app.view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.yedam.app.Observable.Ob_std;
import com.yedam.app.model.Students;
import com.yedam.app.service.impl.StdDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController implements Initializable
{
	@FXML private TableView<Students> tableview;
	
	@FXML private TextField txtStd_id;
	@FXML private TextField txtFirst_name;
	@FXML private TextField txtLast_name;
	@FXML private TextField txtPhone_num;
	@FXML private TextField txtMajor;
	@FXML private TextField txtPasswd;
	
	@FXML TableColumn<Ob_std,String> colStd_id;
	@FXML TableColumn<Ob_std,String> colFirst_name;
	@FXML TableColumn<Ob_std,String> colLast_name;
	@FXML TableColumn<Ob_std,String> colPhone_num;
	@FXML TableColumn<Ob_std,String> colMajor;
	@FXML TableColumn<Ob_std,String> colPasswd;
	
	private Alert alert;
	StdDAO stdDAO = new StdDAO();

	@FXML
	protected void getListStudents(ActionEvent event)
	{
		try {
			ArrayList<Students> list = stdDAO.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		colStd_id.setCellValueFactory(new PropertyValueFactory<Ob_std, String>("std_id"));
		colFirst_name.setCellValueFactory(new PropertyValueFactory<Ob_std, String>("first_name"));
		colLast_name.setCellValueFactory(new PropertyValueFactory<Ob_std, String>("last_name"));
		colPhone_num.setCellValueFactory(new PropertyValueFactory<Ob_std, String>("phone_num"));
		colMajor.setCellValueFactory(new PropertyValueFactory<Ob_std, String>("major"));
		colPasswd.setCellValueFactory(new PropertyValueFactory<Ob_std, String>("colPasswd"));
	}
		

}
