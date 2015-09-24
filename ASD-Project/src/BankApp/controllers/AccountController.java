package BankApp.controllers;

import BankApp.models.BankCustomer;
import BankApp.models.CheckingAccount;
import BankApp.models.SavingsAccount;
import BankApp.ui.BankContentPane;
import framework.CommandManager;
import framework.CreateAccountCommand;
import framework.IAccount;
import framework.ICommand;
import framework.ICustomer;
import framework.MainController;
import framework.Organization;
import framework.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AccountController extends MainController {
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
	private TextField txtNoOfEmployees;

	@FXML
	private TextField txtEMail;

	@FXML
	private RadioButton checkingRB;

	@FXML
	private RadioButton savingsRB;

	@FXML
	private Label lblBirthDate;

	@FXML
	private Label lblNoOfEmployees;

	private ICustomer customer;
	private boolean isPerson;

	public AccountController(ICustomer customer) {
		this.customer = customer;

		isPerson = customer.getClass().equals(BankCustomer.class);
	}
	
	@FXML
	private void initialize(){
		if (isPerson) {
			txtBirthDate.visibleProperty().set(true);
			lblBirthDate.visibleProperty().set(true);
			txtNoOfEmployees.visibleProperty().set(false);
			lblNoOfEmployees.visibleProperty().set(false);
		} else {
			txtBirthDate.visibleProperty().set(false);
			lblBirthDate.visibleProperty().set(false);
			txtNoOfEmployees.visibleProperty().set(true);
			lblNoOfEmployees.visibleProperty().set(true);
		}
	}

	@FXML
	private void closeDialog() {
		Stage stage = (Stage) dialogAnchor.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void Submit() {

		customer.setName(txtName.getText());

		customer.setCity(txtCity.getText());
		customer.setState(txtState.getText());
		customer.setStreet(txtStreet.getText());
		customer.setZip(txtZip.getText());

		IAccount account;
		if (savingsRB.isSelected()) {
			account = new SavingsAccount(customer, txtAccountNumber.getText());
		} else {
			account = new CheckingAccount(customer, txtAccountNumber.getText());
		}

		if (isPerson) {
			((Person) customer).setBirthDate(txtBirthDate.getText());
		} else {
			((Organization) customer).setNumberOfEmployees(txtNoOfEmployees
					.getText());
		}

		ICommand createAccountCommand = new CreateAccountCommand(account);
		CommandManager.getInstance().submit(createAccountCommand);

		// Notify content pane with the changes
		BankContentPane.getInstance().update();

		closeDialog();
	}
}
