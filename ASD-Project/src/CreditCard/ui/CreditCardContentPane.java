package CreditCard.ui;

import java.util.ArrayList;
import java.util.regex.Pattern;

import BankApp.models.BankAccount;
import BankApp.models.SavingsAccount;
import CreditCard.models.CreditCardAccount;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import framework.Account;
import framework.Customer;
import framework.IAccount;
import framework.Person;
import framework.State;
import framework.ui.ContentPane;

public class CreditCardContentPane extends ContentPane {

	private static CreditCardContentPane _BankContentPane;

	private CreditCardContentPane() {

	}

	public static CreditCardContentPane getInstance() {
		if (_BankContentPane == null) {
			_BankContentPane = new CreditCardContentPane();
		}
		return _BankContentPane;
	}

	@FXML
	private TableView<IAccount> tblAccounts;

	@FXML
	private TableColumn<IAccount, String> nameCol;

	@FXML
	private TableColumn<CreditCardAccount, String> ccNumberCol;

	@FXML
	private TableColumn<CreditCardAccount, String> expDateCol;

	@FXML
	private TableColumn<CreditCardAccount, String> typeCol;

	@FXML
	private TableColumn<IAccount, String> balanceCol;

	public TableView<IAccount> getAccountsTV() {
		return tblAccounts;
	}

	@FXML
	private void initialize() {
		nameCol.setCellValueFactory(cellData -> ((Customer) cellData.getValue()
				.getCustomer()).getNameProperty());

		balanceCol.setCellValueFactory(cellData -> ((Account) cellData
				.getValue()).getAmountProperty());

		ccNumberCol.setCellValueFactory(cellData -> new SimpleStringProperty(
				((CreditCardAccount) cellData.getValue()).getCCNumber()));

		expDateCol.setCellValueFactory(cellData -> new SimpleStringProperty(
				((CreditCardAccount) cellData.getValue()).getExpDate()));
		
		typeCol.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getClass().getName().split(Pattern.quote("."))[2]));
	}

	public void update() {
		tblAccounts.getItems().removeAll(
				FXCollections.observableArrayList(State.getInstance()
						.getAccounts()));

		tblAccounts.setItems(FXCollections.observableArrayList(State
				.getInstance().getAccounts()));
	}
}
