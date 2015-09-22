package framework.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;

public class ContentPane extends VBox {
	public ContentPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"..\\..\\"+FinCo.AppName+"\\views\\contentPane.fxml"));

		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
	
	@FXML
	public void exitApp(){
		System.exit(0);
	}
}
