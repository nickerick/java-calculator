package calculator;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CalculatorModelTest {

	public CalculatorModel model;
	public CalculatorController controller;
	public CalculatorView view;
	
	@Before
	public void beforeTest() {
		model = new CalculatorModel();
        controller = new CalculatorController(model);
        view = new CalculatorView(controller, model);
	}
	
	@Test
	public void testAddition() {
		model.setDisplayNum("20");
		model.enterOperation("+");
		model.setDisplayNum("30");
		model.performOperation();
		
		assertEquals(50.0, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testSubtraction() {
		model.setDisplayNum("20");
		model.enterOperation("-");
		model.setDisplayNum("30");
		model.performOperation();
		
		assertEquals(-10.0, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testMultiplication() {
		model.setDisplayNum("20");
		model.enterOperation("*");
		model.setDisplayNum("30");
		model.performOperation();
		
		assertEquals(600.0, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testDivision() {
		model.setDisplayNum("20");
		model.enterOperation("/");
		model.setDisplayNum("30");
		model.performOperation();
		
		assertEquals(0.66, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testSquare() {
		model.setDisplayNum("12");
		model.enterOperation("^2");
		model.performOperation();
		
		assertEquals(144.0, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testSquareRoot() {
		model.setDisplayNum("36");
		model.enterOperation("sqrt");
		model.performOperation();
		
		assertEquals(6.0, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void divisionByZeroError() {
		model.setDisplayNum("450");
		model.enterOperation("/");
		model.setDisplayNum("0");
		model.performOperation();
		
		assertEquals("Error", model.displayNum);
	}
	
	@Test
	public void testStringedOperations() {
		model.setDisplayNum("36");
		model.enterOperation("sqrt");
		model.performOperation();
		model.enterOperation("*");
		model.setDisplayNum("10");
		model.performOperation();
		model.enterOperation("-");
		model.setDisplayNum("5");
		model.performOperation();
		
		assertEquals(55.0, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testMemoryRecall() {
		model.setDisplayNum("5");
		model.enterOperation("+");
		model.setDisplayNum("2");
		model.performOperation(); // 5 + 2 = 7
		model.performSpecialOperation("mplus"); // store 7
		model.enterOperation("+");
		model.setDisplayNum("2"); 
		model.performOperation(); // 7 + 2 = 9
		model.enterOperation("+");
		model.performSpecialOperation("mrecall");
		model.performOperation(); // 9 + 7 = 16
		
		assertEquals(16.0, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testMemoryClear() {
		model.setDisplayNum("5");
		model.enterOperation("+");
		model.setDisplayNum("2");
		model.performOperation(); // 5 + 2 = 7
		model.performSpecialOperation("mplus"); // store 7
		model.enterOperation("+");
		model.setDisplayNum("2"); 
		model.performOperation(); // 7 + 2 = 9
		model.performSpecialOperation("mclear"); // clear memory
		model.enterOperation("+");
		model.performSpecialOperation("mrecall");
		model.performOperation(); // 9 + 0 = 9
		
		assertEquals(9.0, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testClear() {
		model.setDisplayNum("5");
		model.enterOperation("+");
		model.setDisplayNum("2");
		model.performOperation(); // 5 + 2 = 7
		model.performSpecialOperation("mplus"); // store 7
		model.clear();
	
		assertEquals(0.0, (double)Double.valueOf(model.displayNum), 0.01); // check that display 0
		
		model.performSpecialOperation("mrecall"); // recall memory
		assertEquals(0.0, (double)Double.valueOf(model.displayNum), 0.01); // check that memory is 0
	}
	
	
}
