package BankApp.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import BankApp.models.BankAccount;
import BankApp.ui.BankContentPane;
import framework.IAccount;
import framework.IEntry;

public class TransactionController {
	private IEntry entry;
	private BankAccount account;

	@FXML
	private Button btnCancel;

	@FXML
	private AnchorPane dialogAnchor;

	@FXML
	private Label lblAccountNumber;
	
	@FXML
	private TextField txtAmount;
	
	public TransactionController(BankAccount account, IEntry entry) {
		this.entry = entry;
		this.account= account;
	}
	
	@FXML
	private void initialize(){
		lblAccountNumber.setText(this.account.getAccountNumber());
	}

	@FXML
	private void closeDialog() {
		Stage stage = (Stage) dialogAnchor.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void Submit() {

		this.entry.setAmount(Double.parseDouble(txtAmount.getText()));
		this.account.addEntry(this.entry);
		// Notify content pane with the changes
		BankContentPane.getInstance().update();

		closeDialog();
	}
}
