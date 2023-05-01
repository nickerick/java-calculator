package calculator;

import javax.swing.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CalculatorViewTest {

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
	public void testNumInput() {
		JButton one = view.getOne();
		one.doClick();
		
		assertEquals(1.0, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testArithmeticString() {
		JButton one = view.getOne();
		JButton two = view.getTwo();
		JButton plus = view.getPlus();
		JButton minus = view.getMinus();
		JButton sqrt = view.getSqroot();
		JButton divide = view.getDivide();
		JButton enter = view.getEnter();
		
		// set input to 111
		one.doClick();
		one.doClick();
		one.doClick();
		
		// 111 +
		plus.doClick();
		
		// set 21
		two.doClick();
		one.doClick();
		
		// 111 + 21 = 132
		enter.doClick();
		
		// sqrt(132) = 11.489
		sqrt.doClick();
		enter.doClick();
		
		// 11.489 - 1 = 10.489
		minus.doClick();
		one.doClick();
		enter.doClick();
		
		// 10.489 / 2 = 5.25
		divide.doClick();
		two.doClick();
		enter.doClick();
		
		assertEquals(5.25, (double)Double.valueOf(model.displayNum), 0.01);
	}
	
	@Test
	public void testFullFunctionality() {
		JButton one = view.getOne();
		JButton two = view.getTwo();
		JButton plus = view.getPlus();
		JButton minus = view.getMinus();
		JButton sqrt = view.getSqroot();
		JButton divide = view.getDivide();
		JButton mplus = view.getMplus();
		JButton mrecall = view.getMrecall();
		JButton clear = view.getClear();
		JButton delete = view.getDelete();
		JButton enter = view.getEnter();
		
		// set input to 111
		one.doClick();
		one.doClick();
		one.doClick();
		
		// 111 +
		plus.doClick();
		
		// set 21
		two.doClick();
		one.doClick();
		
		// 111 + 21 = 132
		enter.doClick();
		
		// store 132 to memory
		mplus.doClick();
		
		// delete 132.0 from screen
		delete.doClick();
		delete.doClick();
		delete.doClick();
		delete.doClick();
		delete.doClick();
		
		// input 22
		two.doClick();
		two.doClick();
		
		// 22 / 132 (retrieved from memory) = 0.166
		divide.doClick();
		mrecall.doClick();
		enter.doClick();
		assertEquals(0.16, (double)Double.valueOf(model.displayNum), 0.01);
		
		// clear calculator
		clear.doClick();
		
		// input 22
		two.doClick();
		two.doClick();
		
		// 22 / 0 (memory is empty) = 0
		divide.doClick();
		mrecall.doClick();
		enter.doClick();
		
		assertEquals("Error", model.displayNum);
	}
	
	
}
