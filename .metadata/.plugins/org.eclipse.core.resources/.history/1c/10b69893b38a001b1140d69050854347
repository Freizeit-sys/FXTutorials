package application;

public class Model {
	
	private double number1;
	private double number2;
	private String operator;
	
	public void setNumber1(double number1) {
		this.number1 = number1;
	}
	
	public double getNumber1() {
		return this.number1;
	}
	
	public void setNumber2(double number2) {
		this.number2 = number2;
	}
	
	public double getNumber2() {
		return this.number2;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		return this.operator;
	}
	
	public double calculate() {
		switch (operator) {
		case "+":
			return number1 + number2;
		case "-":
			return number1 - number2;
		case "×":
			return number1 * number2;
		case "÷":
			if (number2 == 0) {
				return 0;
			}
			return number1 / number2;
		}
		return 0;
	}
	
	public void clear() {
		this.number1 = 0;
		this.number2 = 0;
		this.operator = "";
	}
}
