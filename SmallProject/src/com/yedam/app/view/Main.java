package com.yedam.app.view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
 
 
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
  

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
//    private Stage primaryStage;
//   private BorderPane rootLayout;


    
    public static void main(String[] args) {
        launch(args);
    }
}
