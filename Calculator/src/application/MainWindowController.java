package application;

import java.math.BigDecimal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainWindowController {
	
	private boolean start = false;
	private Model model = new Model();
	
	@FXML
	private Label result;
	@FXML
	private Button clearButton;
	
	@FXML
	private void processNumpad(ActionEvent event) {
		String oldvalue = result.getText();
		String value = ((Button) event.getSource()).getText();
		// set result
		if (result.getText().matches("^0")) {
			result.setText(value);
		} else {
			if (!start) {
				result.setText(oldvalue + value);
			} else {
				result.setText(value);
			}
		}
		// set number
		if (!start) {
			model.setNumber1(Double.parseDouble(result.getText()));
		} else {
			model.setNumber2(Double.parseDouble(result.getText()));
		}
		// change clear button mode
		if (!result.getText().equals("0")) {
			clearButton.setText("C");
		}
	}
	
	@FXML 
	private void processOperator(ActionEvent event) {
		String value = ((Button) event.getSource()).getText();
		model.setOperator(value);
		start = true;
	}
	
	@FXML 
	private void processClear() {
		model.clear();
		result.setText("0");
		clearButton.setText("AC");
		start = false;
	}
	
	@FXML 
	private void processReverse() {		
		int value = Integer.parseInt(result.getText());
		// set result
		if (result.getText().contains("-")) {
			result.setText(String.valueOf(value).replace("-", ""));
		} else {
			result.setText("-" + String.valueOf(value));
		}
		// set number
		if (!start) {
			model.setNumber1(value);
		} else {
			model.setNumber2(value);
		}
	}
	
	@FXML
	private void processPercentage() {
		double num = Double.parseDouble(result.getText());
		if (result.getText().matches("[0-9]\\.[0-9]")) {
			result.setText(String.valueOf((int) num * 100));
		} else {
			result.setText(BigDecimal.valueOf(num / 100).toString());
		}
	}
	
	@FXML 
	private void processCalculate() {
		int result = (int) model.calculate();
		if (start) {
			this.result.setText(String.valueOf(result));
			model.setNumber1(result);
		}
	}
}   
