package BankApp.controllers;

import BankApp.models.CheckingAccount;
import BankApp.models.SavingsAccount;
import BankApp.ui.BankContentPane;
import framework.CommandManager;
import framework.CreateAccountCommand;
import framework.IAccount;
import framework.ICommand;
import framework.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DialogController {
	@FXML
	private Button btnCancel;

	@FXML
	private AnchorPane dialogAnchor;

	@FXML
	private TextField txtAccountNumber;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtStreet;

	@FXML
	private TextField txtCity;

	@FXML
	private TextField txtState;

	@FXML
	private TextField txtZip;

	@FXML
	private TextField txtBirthDate;

	@FXML
	private TextField txtEMail;

	@FXML
	private RadioButton checkingRB;

	@FXML
	private RadioButton savingsRB;

	@FXML
	private void closeDialog() {
		Stage stage = (Stage) dialogAnchor.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void Submit() {
		Person person = new Person();
		person.setName(txtName.getText());
		person.setBirthDate(txtBirthDate.getText());
		person.setCity(txtCity.getText());
		person.setState(txtState.getText());
		person.setStreet(txtStreet.getText());
		person.setZip(txtZip.getText());
		
		IAccount account;
		if(savingsRB.isSelected())
		{
			account= new SavingsAccount(person, txtAccountNumber.getText());
		}else
		{
			account= new CheckingAccount(person, txtAccountNumber.getText());
		}

		ICommand createAccountCommand= new CreateAccountCommand(account);
		CommandManager.getInstance().submit(createAccountCommand);
		
		//Notify content pane with the changes
		BankContentPane.getInstance().update();
		
		closeDialog();
	}
}
