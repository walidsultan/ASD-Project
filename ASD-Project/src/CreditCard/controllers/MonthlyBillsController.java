package CreditCard.controllers;

import java.util.Date;
import java.util.Calendar;

import CreditCard.models.Charge;
import CreditCard.models.CreditCardAccount;
import framework.Account;
import framework.IAccount;
import framework.IEntry;
import framework.State;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class MonthlyBillsController {

	@FXML
	private AnchorPane dialogAnchor;

	@FXML
	private void closeDialog() {
		Stage stage = (Stage) dialogAnchor.getScene().getWindow();
		stage.close();
	}

	@FXML
	private TextArea txtReport;

	@FXML
	private void initialize() {
		StringBuilder report = new StringBuilder();
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		calendar.add(Calendar.MONTH, -1);
		Date previousMonth = calendar.getTime();
		calendar.add(Calendar.MONTH, -1);
		Date twoMonthsAgo = calendar.getTime();

		Calendar.getInstance().add(Calendar.MONTH, -2);
		for (IAccount account : State.getInstance().getAccounts()) {
			report.append("Name: " + account.getCustomer().getName() + "\n");
			double previousBalance = getBalance(account, twoMonthsAgo,
					previousMonth);
			report.append("Previous Balance: " + previousBalance + "\n");
			Pair<Double, Double> data = getAccountData(account);
			report.append("Total Credits: " + data.getKey() + "\n");
			report.append("Total Charges: " + data.getValue() + "\n");
			double newBalance = (previousBalance - data.getKey()
					+ data.getValue() + ((CreditCardAccount) account)
					.getMonthlyIntrestRate()
					* (previousBalance - data.getKey()));
			report.append("New Balance: " + newBalance + "\n");
			report.append("Total Due: " + newBalance
					* ((CreditCardAccount) account).getMinimumPayment() + "\n");
			report.append("\n");
		}

		txtReport.setText(report.toString());
	}

	private double getBalance(IAccount account, Date startDate, Date endDate) {
		double balance = 0;
		for (IEntry entry : account.getAllEntries()) {
			if (entry.getDate().compareTo(startDate) > 0
					&& entry.getDate().compareTo(endDate) < 0) {
				balance = entry.compute(balance);
			}
		}
		return balance;
	}

	private Pair<Double, Double> getAccountData(IAccount account) {
		double credits = 0;
		double charges = 0;
		for (IEntry entry : account.getAllEntries()) {
			if (entry.getClass().equals(Charge.class)) {
				charges += entry.getAmount();
			} else {
				credits += entry.getAmount();
			}

		}
		return new Pair<Double, Double>(credits, charges);
	}
}
