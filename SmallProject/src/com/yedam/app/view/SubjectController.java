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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SubjectController implements Initializable {
	
	static Stage dialog = new Stage(StageStyle.UTILITY);
	
	
	@FXML
	private TableView<Subject> tableView;
	@FXML
	private TableView<Subject> tableView1;

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

	@FXML
	private TextField txStd_info;
	@FXML
	private TextField txtSubject_code_register;
	@FXML
	private TextField txtSubject_register_delete;
	@FXML
	private Button list;

	@FXML
	TableColumn<Ob_subject, String> colSubject_code;
	@FXML
	TableColumn<Ob_subject, String> colSubject_name;
	@FXML
	TableColumn<Ob_subject, String> colSubject_explain;
	@FXML
	TableColumn<Ob_subject, String> colSubject_group_code;
	@FXML
	TableColumn<Ob_subject, String> colSubject_start_day;
	@FXML
	TableColumn<Ob_subject, String> colSubject_end_day;
	@FXML
	TableColumn<Ob_subject, String> colSubject_start_time;
	@FXML
	TableColumn<Ob_subject, String> colSubject_end_time;
	@FXML
	TableColumn<Ob_subject, String> colSubject_y_s;
	@FXML
	TableColumn<Ob_subject, String> colClass_point;
	@FXML
	TableColumn<Ob_subject, String> colGrade;
	@FXML
	TableColumn<Ob_subject, String> colSubject_day;

	@FXML
	TableColumn<Ob_subject, String> colSubject_code1;
	@FXML
	TableColumn<Ob_subject, String> colSubject_name1;
	@FXML
	TableColumn<Ob_subject, String> colSubject_explain1;
	@FXML
	TableColumn<Ob_subject, String> colSubject_group_code1;
	@FXML
	TableColumn<Ob_subject, String> colSubject_start_day1;
	@FXML
	TableColumn<Ob_subject, String> colSubject_end_day1;
	@FXML
	TableColumn<Ob_subject, String> colSubject_start_time1;
	@FXML
	TableColumn<Ob_subject, String> colSubject_end_time1;
	@FXML
	TableColumn<Ob_subject, String> colSubject_y_s1;
	@FXML
	TableColumn<Ob_subject, String> colClass_point1;
	@FXML
	TableColumn<Ob_subject, String> colGrade1;
	@FXML
	TableColumn<Ob_subject, String> colSubject_day1;

	ArrayList<Subject> register_list = new ArrayList<>(); // 이미 데이터 베이스에 있는 값들을 들고오는 배열
	// ArrayList<Subject> register_list_new = new ArrayList<>(); // 수강신청 새로 넣는곳

	private Alert alert;
	SubjectDAO subjectDAO = new SubjectDAO();
	RegisterDAO registerDAO = new RegisterDAO();

	@FXML
	TextField point;
	int enable_point = 15;

	public void getRegister_list() {
		Connection conn = DAO.getConnect();
		Subject temp_subject = null;
		String sql = "select * from subject a,register_subject_class b where a.subject_code = b.subject_code and b.std_id = ? ";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LoginController.getConn_info());
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

				// System.out.println(temp_subject);// 불러오는거 확인 인제 뿌려주기만하면덴다.
				register_list.add(temp_subject);

			}
			rs.close();
			tableView1.setItems(FXCollections.observableArrayList(register_list));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	protected void getInformation1(MouseEvent event) {
		if (tableView1.getSelectionModel().getSelectedItem() != null) {
			txtSubject_register_delete.setText(tableView1.getSelectionModel().getSelectedItem().getSubject_code());
		}

	}

	@FXML
	protected void delete_register_list(ActionEvent event) {
		String delete_code = txtSubject_register_delete.getText();
		registerDAO.delete_register_subject(delete_code);

		if (delete_code != null) {
			for (int i = 0; i < register_list.size(); i++) {
				if (register_list.get(i).getSubject_code().equals(delete_code)) {
					point.setText(String.valueOf(Integer.parseInt(point.getText())
							+ Integer.parseInt(register_list.get(i).getClass_point())));
					register_list.remove(i);
				}
			}

		}

		if (register_list == null) {
			for (int i = 0; i < register_list.size();) {
				register_list.remove(i);
			}
		}
		tableView1.setItems(FXCollections.observableArrayList(register_list));

	}

	@FXML
	protected void init_register_list(ActionEvent event) {
		Connection conn = DAO.getConnect();
		String sql = "truncate table register_subject_class ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < register_list.size();)// 하나씩 지워지고 정렬되기 때문에 i++해줄필요 없다.
		{
			register_list.remove(i);
		}
		// 다지워도 오류안남
		tableView1.setItems(FXCollections.observableArrayList(register_list));

	}

	@FXML
	protected void getListOfRegisterSubject(ActionEvent event) {
		boolean check = true;
		if (txtSubject_code_register.getText() != null) {
			String add_value = txtSubject_code_register.getText();
			try {

				Subject subject_temp = subjectDAO.selectOne(add_value);
				for (int i = 0; i < register_list.size(); i++) // 밑에 추가된 창에도 없어야 하고
				{
					if (register_list.get(i).getSubject_day().equals(subject_temp.getSubject_day()) && register_list
							.get(i).getSubject_start_time().equals(subject_temp.getSubject_start_time())) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Program Information");
						alert.setHeaderText("경고");
						alert.setContentText("Time overlap! Please Check time! -");
						alert.show();
						check = false;
						break;
					}

					if (register_list.get(i).getSubject_code().equals(add_value)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Program Information");
						alert.setHeaderText("warnning!!");
						alert.setContentText("This subject is already registered!");
						alert.show();
						check = false;
						break;
					}

				}
				// 시간 겹치는거랑 동일한 과목있는지 확인하는 위의 for문에서 check가 false가아니면 마지막으로 남은 학점을 계산한다.
				if (check) {
					if (Integer.parseInt(point.getText()) - Integer.parseInt(subject_temp.getClass_point()) < 0) {
						check = false;
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Program Information");
						alert.setHeaderText("warnning!!");
						alert.setContentText("Check your remained grade point !!!");
						alert.show();
					} else {
						enable_point = Integer.parseInt(point.getText())
								- Integer.parseInt(subject_temp.getClass_point());
						point.setText(String.valueOf(enable_point));
					}

				}
				// 남은 학점 까지 확인하고 check가 false 가 가니면 리스트에 추가한다.
				if (check) {
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
	protected void add_std_register_list(ActionEvent event) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

		String str = sd.format(new Date()); // 0000년 00월 00 일 00:00:00 형식으로 얻어옴

		for (int i = 0; i < register_list.size(); i++) {
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
		
		
			try {
				dialog.close();
				AnchorPane TimeView = FXMLLoader.load(getClass().getResource("TimeTable.fxml"));
				// Stage primStage = (Stage) txStd_info.getScene().getWindow();
				dialog = new Stage(StageStyle.UTILITY);
				// dialog = (Stage) txStd_info.getScene().getWindow();
				// dialog.initModality(Modality.WINDOW_MODAL); // 마우스 커서 제한거는 옵션
				// dialog.initOwner(primStage);
				dialog.setTitle("timeTable"); // 상단 제목
				Scene scene = new Scene(TimeView);
				dialog.setScene(scene);
				dialog.setResizable(false);
				dialog.show();	
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		
		
	}

	@FXML
	protected void getListSuject(ActionEvent event) {

		try {
			ArrayList<Subject> list = subjectDAO.selectAll();// 그냥 subject class를 넣은 ArrayList

			tableView.setItems(FXCollections.observableArrayList(list));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void ShowStudentInfo() {
		Connection conn = DAO.getConnect();
		Students temp_students = null;
		String sql = "select * from student_info where std_id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			String conn_id = LoginController.getConn_info();

			pstmt.setString(1, conn_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
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

		txStd_info.setText("학번: " + String.valueOf(temp_students.getStd_id()) + " 성: " + temp_students.getLastName()
				+ " 이름: " + temp_students.getFirstName() + " 전공: " + temp_students.getMajor());

	}

	@FXML
	protected void getInformation(MouseEvent event) {
		if (tableView.getSelectionModel().getSelectedItem() != null) {
			txtSubject_code_register.setText(tableView.getSelectionModel().getSelectedItem().getSubject_code());
		}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ShowStudentInfo();

		colSubject_code.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_code")); // 형변환 된듯
		colSubject_name.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_name"));
		colSubject_explain.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_explain"));
		colSubject_group_code.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_group_code"));
		colSubject_start_day.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_start_day"));
		colSubject_end_day.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_day"));
		colSubject_start_time.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_start_time"));
		colSubject_end_time.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_end_time"));
		colSubject_y_s.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_y_s"));
		colClass_point.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("class_point"));
		// colGrade1.setCellValueFactory(new PropertyValueFactory<Ob_subject,
		// String>("grade"));
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
		// colGrade1.setCellValueFactory(new PropertyValueFactory<Ob_subject,
		// String>("grade"));
		colSubject_day1.setCellValueFactory(new PropertyValueFactory<Ob_subject, String>("subject_day"));

		// 이미 수강신청해놓은 수강신청 목록 띄우기
		getRegister_list();

		// 수강가능한 학점 조회해서 띄우기
		showEnable_point();
		
		

	}

	public void showEnable_point() {
		Connection conn = DAO.getConnect();
		String sql = "select * from subject a,register_subject_class b where a.subject_code = b.subject_code and b.std_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, LoginController.getConn_info());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				enable_point = enable_point - Integer.parseInt(rs.getString("class_point"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		point.setText(String.valueOf(enable_point));

	}

}
