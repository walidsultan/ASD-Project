package BankApp.ui;



import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import framework.ui.FinCo;
import framework.ui.HeaderPane;
import framework.Person;
public class BankHeaderPane extends HeaderPane {

	@FXML
	private void addPersonalAccount() throws IOException {
		
		Stage dialog = new Stage();
		dialog.initStyle(StageStyle.UTILITY);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"..\\..\\BankApp\\views\\AddPersonalAccountDialog.fxml"));
				
		Scene scene = new Scene(fxmlLoader.load());
		dialog.setTitle("Add Personal Account");
		dialog.setScene(scene);
		dialog.show();
	}
	
	
}
