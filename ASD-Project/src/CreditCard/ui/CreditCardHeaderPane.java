package CreditCard.ui;

import java.io.IOException;

import CreditCard.controllers.AccountController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import framework.ui.HeaderPane;
import framework.ICustomer;
import framework.Person;

public class CreditCardHeaderPane extends HeaderPane {

	@FXML
	private void addCreditCardAccount() throws IOException {
		showAccountDialog(new Person(), "Add Credit-Card Account");
	}

	@FXML
	private void generateMonthlyBills(){
		
	}

	private void showAccountDialog(ICustomer customer, String title)
			throws IOException {
		Stage dialog = new Stage();
		dialog.initStyle(StageStyle.UTILITY);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"..\\..\\CreditCard\\views\\AddAccountDialog.fxml"));
		fxmlLoader.setController(new AccountController(customer));

		Scene scene = new Scene(fxmlLoader.load());
		dialog.setTitle(title);
		dialog.setScene(scene);
		dialog.show();
	}

}
