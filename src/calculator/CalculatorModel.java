package calculator;

/*
 * This is the model objecct that holds all the data the Calculator uses. This also holds all the logical
 * operations such arithmetic and memory management.
 */
public class CalculatorModel {
	private double mem; // value stored in memory
	public String displayNum; // value currently displayed on screen
	private double storedNum; // first operand --> if 54 + 34 then storedNum = 54 and displayNum = 34
	private String operation; // selected operand (+, -, etc.)
	private boolean isSecond; // helper to check when to reset display on num input
	private boolean isResult; // helper to check if memory functions are valid
	
	public CalculatorModel() {
		mem = 0;
		displayNum = "";
		storedNum = 0;
		operation = "";
		isSecond = false;
		isResult = false;
	}
	
	// Handles number inputs to calculator
	public void addNum(int num) {
		isResult = false;
		
		if (isSecond) {
			setDisplayNum("");
			isSecond = false;
		}
		
		if (num == 10) {
			if (!displayNum.contains(".")) {
				setDisplayNum(displayNum + ".");				
			}
		} else {
			setDisplayNum(displayNum + num);			
		}
	}
	
	// Deletes lastly entered number
	public void deleteNum() { 
		if (displayNum.length() > 0) {
			setDisplayNum(displayNum.substring(0, displayNum.length() - 1));
		}			
	}
	
	// Handles currently selected operation (e.g. add, subtract, etc.)
	public void enterOperation(String type) {
		setStoredNum(Double.valueOf(displayNum));
		operation = type;
		isSecond = true;
	}
	
	// setter method to set display value
	public void setDisplayNum(String num) {
		this.displayNum = num;
	}
	
	// setter method for storednum
	public void setStoredNum(double num) {
		this.storedNum = num;
	}
	
	// Handles the equal button input. This processes the proper operation 
	// the correct input values and handles any errors if they exist.
	public void performOperation() {
		double num2 = Double.valueOf(displayNum);
		if (operation == "+") {
			try {
				displayNum = (storedNum + num2) + "";
				isResult = true;
			} catch (Exception e) {
				displayNum = "Error";
			}
		} else if (operation == "-") {
			try {
				displayNum = (storedNum - num2) + "";
				isResult = true;
			} catch (Exception e) {
				displayNum = "Error";
			}
		} else if (operation == "/") {
			try {
				displayNum = (storedNum / num2) + "";
				
				if (displayNum.equals("Infinity")) {
					throw new Exception();
				}
				
				isResult = true;
			} catch (Exception e) {
				displayNum = "Error";
			}
		} else if (operation == "*") {
			try {
				displayNum = (storedNum * num2) + "";
				isResult = true;
			} catch (Exception e) {
				displayNum = "Error";
			}	
		} else if (operation == "^2") {
			try {
				displayNum = (num2 * num2) + "";
				isResult = true;
			} catch (Exception e) {
				displayNum = "Error";
			}
		} else if (operation == "sqrt") {
			try {
				displayNum = (Math.sqrt(num2)) + "";
				isResult = true;
			} catch (Exception e) {
				displayNum = "Error";
			}			
		}
	}
	
	// Handles the four memory functions
	public void performSpecialOperation(String operation) {
		double num2 = 0;
		
		if (!displayNum.equals("")) {
			num2 = Double.valueOf(displayNum);
		}
		
		if (operation == "mplus") {
			if (isResult) {
				mem += num2;
			} else {
				displayNum = "Error";
			}
		} else if (operation == "mminus") {
			if (isResult) {
				mem -= num2;
			} else {
				displayNum = "Error";
			}			
		} else if (operation == "mrecall") {
			displayNum = mem + "";	
		} else if (operation == "mclear") {
			mem = 0;	
		} 
	}
	
	// handles clear inputs
	public void clear() {
		displayNum = "0";
		mem = 0;
		isSecond = true;
		storedNum = 0;
	}
}
