package framework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinCo extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader myLoader = new FXMLLoader(getClass().getResource("MainLayout.fxml"));
			Parent loadScreen = (Parent) myLoader.load();
			
			Scene scene = new Scene(loadScreen,600,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Default Framework App");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

