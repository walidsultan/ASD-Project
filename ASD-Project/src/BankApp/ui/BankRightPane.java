package BankApp.ui;

import java.io.IOException;

import BankApp.controllers.TransactionController;
import BankApp.models.BankAccount;
import BankApp.models.Deposit;
import BankApp.models.Withdraw;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import framework.IEntry;
import framework.ui.RightPane;

public class BankRightPane extends RightPane {
	@FXML
	private void withdraw() throws IOException {
		showTransaction(new Withdraw(), "Withdraw");
	}

	@FXML
	private void deposit() throws IOException {
		showTransaction(new Deposit(), "Deposit");
	}

	private void showTransaction(IEntry entry, String title) throws IOException {
		int selectedIndex = BankContentPane.getInstance().getAccountsTV()
				.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			BankAccount account = (BankAccount) BankContentPane.getInstance()
					.getAccountsTV().getItems().get(selectedIndex);
			showTransactionDialog(account, entry, title);
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No Account Selected");
			alert.setHeaderText(null);
			alert.setContentText("Please select an account from the table.");
			alert.showAndWait();
		}
	}

	private void showTransactionDialog(BankAccount account, IEntry entry,
			String title) throws IOException {
		Stage dialog = new Stage();
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initStyle(StageStyle.UTILITY);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"..\\..\\BankApp\\views\\AddTransactionDialog.fxml"));
		fxmlLoader.setController(new TransactionController(account, entry));

		Scene scene = new Scene(fxmlLoader.load());
		dialog.setTitle(title);
		dialog.setScene(scene);
		dialog.show();
	}
}
