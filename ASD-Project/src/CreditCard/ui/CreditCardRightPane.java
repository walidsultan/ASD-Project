package CreditCard.ui;

import java.io.IOException;

import CreditCard.controllers.TransactionController;
import CreditCard.models.Charge;
import CreditCard.models.CreditCardAccount;
import CreditCard.models.Deposit;
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

public class CreditCardRightPane extends RightPane {
	@FXML
	private void charge() throws IOException {
		showTransaction(new Charge(), "Charge");
	}

	@FXML
	private void deposit() throws IOException {
		showTransaction(new Deposit(), "Deposit");
	}

	private void showTransaction(IEntry entry, String title) throws IOException {
		int selectedIndex = CreditCardContentPane.getInstance().getAccountsTV()
				.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			CreditCardAccount account = (CreditCardAccount) CreditCardContentPane.getInstance()
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

	private void showTransactionDialog(CreditCardAccount account, IEntry entry,
			String title) throws IOException {
		Stage dialog = new Stage();
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initStyle(StageStyle.UTILITY);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"..\\..\\CreditCard\\views\\AddTransactionDialog.fxml"));
		fxmlLoader.setController(new TransactionController(account, entry));

		Scene scene = new Scene(fxmlLoader.load());
		dialog.setTitle(title);
		dialog.setScene(scene);
		dialog.show();
	}
}
