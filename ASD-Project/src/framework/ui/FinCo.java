package framework.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinCo extends Application {
	public static String AppName="Framework"; 
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader myLoader = new FXMLLoader(getClass().getResource("..\\..\\framework\\Views\\MainLayout.fxml"));
			Parent loadScreen = (Parent) myLoader.load();
			
			Scene scene = new Scene(loadScreen,600,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		
			String title= getAppTitle() ;
			primaryStage.setTitle(title);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getAppTitle() {
		return "Default Framework App";
	}

	public static void main(String[] args) {
		launch(args);
	}
}

