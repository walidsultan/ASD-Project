package BankApp.ui;

import java.io.IOException;

import BankApp.commands.AddInterestCommand;
import BankApp.controllers.AccountController;
import BankApp.models.BankCustomer;
import BankApp.models.Company;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import framework.ui.HeaderPane;
import framework.CommandManager;
import framework.ICommand;
import framework.ICustomer;

public class BankHeaderPane extends HeaderPane {

	@FXML
	private void addPersonalAccount() throws IOException {
		showAccountDialog(new BankCustomer(), "Add Personal Account");
	}

	@FXML
	private void addCompanyAccount() throws IOException {
		showAccountDialog(new Company(), "Add Company Account");
	}

	@FXML
	private void addInterest() {
		ICommand addInterestCommand = new AddInterestCommand();

		CommandManager.getInstance().submit(addInterestCommand);

		BankContentPane.getInstance().update();
	}

	private void showAccountDialog(ICustomer customer, String title)
			throws IOException {
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
