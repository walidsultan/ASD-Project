package CreditCard.controllers;

import CreditCard.commands.TransactionCommand;
import CreditCard.models.CreditCardAccount;
import CreditCard.ui.CreditCardContentPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import framework.CommandManager;
import framework.ICommand;
import framework.IEntry;
import framework.MainController;

public class TransactionController extends MainController{
	private IEntry entry;
	private CreditCardAccount account;

	@FXML
	private Button btnCancel;

	@FXML
	private AnchorPane dialogAnchor;

	@FXML
	private Label lblName;
	
	@FXML
	private TextField txtAmount;
	
	public TransactionController(CreditCardAccount account, IEntry entry) {
		this.entry = entry;
		this.account= account;
	}
	
	@FXML
	private void initialize(){
		lblName.setText(this.account.getCustomer().getName());
	}

	@FXML
	private void closeDialog() {
		Stage stage = (Stage) dialogAnchor.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void Submit() {
		ICommand transactionCommand= new TransactionCommand(this.account, this.entry,Double.parseDouble(txtAmount.getText()));
		CommandManager.getInstance().submit(transactionCommand);
		
		// Notify content pane with the changes
		CreditCardContentPane.getInstance().update();

		closeDialog();
	}
}
