package calculator;

import javax.swing.JFrame;

public class CalculatorDriver {

	/*
	 * Main Driving Function of Calculator App
	 */
	public static void main(String[] args) {
		
		// MVC objects instantiation
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(model);
        CalculatorView view = new CalculatorView(controller, model);

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(view.getPanel());
        frame.pack();
        frame.setSize(210, 360);
        frame.setVisible(true);
    }
}
