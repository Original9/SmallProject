package com.yedam.app.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}

	@Override
	public void start(Stage primarystage) throws Exception {
		this.primaryStage = primarystage;
		initRootLayout();
//		showSubjectApply();
		showLogin();

	}

	public void initRootLayout() {
		try {
			rootLayout = FXMLLoader.load(getClass().getResource("root.fxml"));
			Scene scene = new Scene(rootLayout, 850, 800);
			primaryStage.setTitle("Root");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void showLogin() {
		try {
			AnchorPane loginview = FXMLLoader.load(getClass().getResource("Login.fxml"));
			rootLayout.setCenter(loginview);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
