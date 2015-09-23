package CreditCard.controllers;


import CreditCard.models.Bronze;
import CreditCard.models.CreditCardAccount;
import CreditCard.models.Gold;
import CreditCard.models.Silver;
import CreditCard.ui.CreditCardContentPane;
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
	private TextField txtEMail;


	@FXML
	private TextField txtCCNumber;

	@FXML
	private TextField txtExpDate;
	
	

	@FXML
	private RadioButton goldRB;

	@FXML
	private RadioButton silverRB;

	@FXML
	private RadioButton bronzeRB;

	private ICustomer customer;

	public AccountController(ICustomer customer) {
		this.customer = customer;

	}
	
	@FXML
	private void initialize(){
//		if (isPerson) {
//			txtBirthDate.visibleProperty().set(true);
//			lblBirthDate.visibleProperty().set(true);
//			txtNoOfEmployees.visibleProperty().set(false);
//			lblNoOfEmployees.visibleProperty().set(false);
//		} else {
//			txtBirthDate.visibleProperty().set(false);
//			lblBirthDate.visibleProperty().set(false);
//			txtNoOfEmployees.visibleProperty().set(true);
//			lblNoOfEmployees.visibleProperty().set(true);
//		}
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

		CreditCardAccount account;
		if (goldRB.isSelected()) {
			account = new Gold(customer);
		} else if (silverRB.isSelected()){
			account = new Silver(customer);
		}else
		{
			account = new Bronze(customer);
		}

		account.setCCNumber(txtCCNumber.getText());
		account.setExpDate(txtExpDate.getText());

//		if (isPerson) {
//			((Person) customer).setBirthDate(txtBirthDate.getText());
//		} else {
//			((Organization) customer).setNumberOfEmployees(txtNoOfEmployees
//					.getText());
//		}

		ICommand createAccountCommand = new CreateAccountCommand(account);
		CommandManager.getInstance().submit(createAccountCommand);

		// Notify content pane with the changes
		CreditCardContentPane.getInstance().update();

		closeDialog();
	}
}
