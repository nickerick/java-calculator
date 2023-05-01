package calculator;

/*
 * This is the controller class that connects actions from the view to logic. 
 */
public class CalculatorController {
	private CalculatorModel calcModel;
	
	public CalculatorController(CalculatorModel calcModel) {
		this.calcModel = calcModel;
	}
	
	public void addNum(int num) {
		calcModel.addNum(num);
	}
	
	public void deleteNum() { 
		calcModel.deleteNum();		
	}
	
	public void clear() {
		calcModel.clear();
	}
	
	public void enterOperation(String type) {
		calcModel.enterOperation(type);
	}
	
	public void performOperation() {
		calcModel.performOperation();
	}
	
	public void performSpecialOperation(String operation) {
		calcModel.performSpecialOperation(operation);
	}
	
}
