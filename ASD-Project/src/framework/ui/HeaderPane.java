package framework.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class HeaderPane extends HBox {
	public HeaderPane() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"../../"+FinCo.AppName+"/views/headerPane.fxml"));

		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}
	
}
