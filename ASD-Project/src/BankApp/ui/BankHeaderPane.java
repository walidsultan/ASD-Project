package BankApp.ui;

import java.io.IOException;

import BankApp.controllers.AccountController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import framework.ui.HeaderPane;
import framework.ICustomer;
import framework.Organization;
import framework.Person;
public class BankHeaderPane extends HeaderPane {

	@FXML
	private void addPersonalAccount() throws IOException {
		showAccountDialog(new Person(),"Add Personal Account");
	}
	
	@FXML
	private void addCompanyAccount() throws IOException {
		showAccountDialog(new Organization(),"Add Company Account");
	}

	private void showAccountDialog(ICustomer customer,String title) throws IOException {
		Stage dialog = new Stage();
		dialog.initStyle(StageStyle.UTILITY);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"..\\..\\BankApp\\views\\AddAccountDialog.fxml"));
		fxmlLoader.setController(new AccountController(customer));
		
		Scene scene = new Scene(fxmlLoader.load());
		dialog.setTitle(title);
		dialog.setScene(scene);
		dialog.show();
	}
	
	
	
	
}
