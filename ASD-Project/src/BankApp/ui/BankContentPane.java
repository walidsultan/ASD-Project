package BankApp.ui;

import BankApp.models.BankAccount;
import BankApp.models.SavingsAccount;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import framework.Customer;
import framework.IAccount;
import framework.Person;
import framework.State;
import framework.ui.ContentPane;

public class BankContentPane extends ContentPane {

	private static BankContentPane _BankContentPane;

	private BankContentPane() {

	}

	public static BankContentPane getInstance() {
		if (_BankContentPane == null) {
			_BankContentPane = new BankContentPane();
		}
		return _BankContentPane;
	}

	@FXML
	private TableView<IAccount> tblAccounts;

	@FXML
	private TableColumn<IAccount, String> accountNoCol;

	@FXML
	private TableColumn<BankAccount, String> nameCol;

	@FXML
	private TableColumn<BankAccount, String> cityCol;

	@FXML
	private TableColumn<IAccount, String> amountCol;

	@FXML
	private TableColumn<BankAccount, String> pcCol;

	@FXML
	private TableColumn<BankAccount, String> chsCol;

	public void update() {
		accountNoCol
				.setCellValueFactory(new PropertyValueFactory<IAccount, String>(
						"accountNumber"));

		nameCol.setCellValueFactory(cellData -> ((Customer) cellData.getValue()
				.getCustomer()).getNameProperty());

		cityCol.setCellValueFactory(cellData -> ((Customer) cellData.getValue()
				.getCustomer()).getCityProperty());

		amountCol
				.setCellValueFactory(new PropertyValueFactory<IAccount, String>(
						"amount"));

		pcCol.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getCustomer().getClass()
						.equals(Person.class) ? "Person" : "Company"));

		chsCol.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getClass().equals(SavingsAccount.class) ? "Savings"
						: "Checking"));

		tblAccounts.setItems(FXCollections.observableArrayList(State.Accounts));
	}
}
