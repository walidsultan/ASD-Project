package BankApp.ui;

import java.io.IOException;

import BankApp.controllers.AccountController;
import BankApp.models.BankAccount;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import framework.ui.HeaderPane;
import framework.Account;
import framework.IAccount;
import framework.ICustomer;
import framework.Organization;
import framework.Person;
import framework.State;
public class BankHeaderPane extends HeaderPane {

	@FXML
	private void addPersonalAccount() throws IOException {
		showAccountDialog(new Person(),"Add Personal Account");
	}
	
	@FXML
	private void addCompanyAccount() throws IOException {
		showAccountDialog(new Organization(),"Add Company Account");
	}

	@FXML
	private void addInterest()  {
		for(IAccount account: State.getInstance().getAccounts()){
			account.setAmount(account.getAmount()+account.getAmount()*.1);
		}
		BankContentPane.getInstance().update();
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
