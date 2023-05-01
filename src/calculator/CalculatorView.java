package calculator;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/*
 * This class contains the view implementation of the calculator.
 * The layout out of the buttons as well as the display of the calculator operations
 * are managed here. This class calls controller methods on button presses and displays
 * data from the model.
 */
public class CalculatorView {
	private CalculatorController controller;
	private CalculatorModel model;
	private JLabel inputBox;
	private JButton zero;
	private JButton one; 
	private JButton two; 
	private JButton three; 
	private JButton four; 
	private JButton five; 
	private JButton six;  
	private JButton seven; 
	private JButton eight; 
	private JButton nine;
	private JButton decimal;
	private JButton clear; 
	private JButton plus;
	private JButton minus; 
	private JButton divide;
	private JButton multiply;
	private JButton mplus; 
	private JButton mminus;
	private JButton mrecall;
	private JButton mclear;
	private JButton delete;
	private JButton enter; 
	private JButton square; 
	private JButton sqroot; 
	
	public CalculatorView(CalculatorController controller, CalculatorModel model) {
		this.controller = controller;
		this.model = model;
		inputBox = new JLabel(model.displayNum);
		zero = new JButton("0");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		decimal = new JButton(".");
		clear = new JButton("C");
		plus = new JButton("+");
		minus = new JButton("-");
		divide = new JButton("/");
		multiply = new JButton("*");
		mplus = new JButton("M+");
		mminus = new JButton("M-");
		mrecall = new JButton("M-R");
		mclear = new JButton("M-C");
		delete = new JButton("Del");
		enter = new JButton("=");
		square = new JButton("^2");
		sqroot = new JButton("sqrt");
		
		// Adding appropriate event listeners to all buttons
		zero.addActionListener(e -> {
			controller.addNum(0);
			setDisplay(model.displayNum);
		});
		
		one.addActionListener(e -> {
			controller.addNum(1);
			setDisplay(model.displayNum);
		});
		
		two.addActionListener(e -> {
			controller.addNum(2);
			setDisplay(model.displayNum);
		});
		
		three.addActionListener(e -> {
			controller.addNum(3);
			setDisplay(model.displayNum);
		});
		
		four.addActionListener(e -> {
			controller.addNum(4);
			setDisplay(model.displayNum);
		});
		
		five.addActionListener(e -> {
			controller.addNum(5);
			setDisplay(model.displayNum);
		});
		
		six.addActionListener(e -> {
			controller.addNum(6);
			setDisplay(model.displayNum);
		});
		
		seven.addActionListener(e -> {
			controller.addNum(7);
			setDisplay(model.displayNum);
		});
		
		eight.addActionListener(e -> {
			controller.addNum(8);
			setDisplay(model.displayNum);
		});
		
		nine.addActionListener(e -> {
			controller.addNum(9);
			setDisplay(model.displayNum);
		});
		
		decimal.addActionListener(e -> {
			controller.addNum(10);
			setDisplay(model.displayNum);
		});
		
		delete.addActionListener(e -> {
			controller.deleteNum();
			setDisplay(model.displayNum);
		});
		
		clear.addActionListener(e -> {
			controller.clear();
			setDisplay(model.displayNum);
		});

		plus.addActionListener(e -> {
			plus.setBackground(Color.RED);
			controller.enterOperation("+");
		});
		
		minus.addActionListener(e -> {
			minus.setBackground(Color.RED);
			controller.enterOperation("-");
		});
		
		multiply.addActionListener(e -> {
			multiply.setBackground(Color.RED);
			controller.enterOperation("*");
		});
		
		divide.addActionListener(e -> {
			divide.setBackground(Color.RED);
			controller.enterOperation("/");
		});
		
		square.addActionListener(e -> {
			square.setBackground(Color.RED);
			controller.enterOperation("^2");
		});
		
		sqroot.addActionListener(e -> {
			sqroot.setBackground(Color.RED);
			controller.enterOperation("sqrt");
		});
		
		mplus.addActionListener(e -> {
			controller.performSpecialOperation("mplus");
			setDisplay(model.displayNum);
		});
		
		mminus.addActionListener(e -> {
			controller.performSpecialOperation("mminus");
			setDisplay(model.displayNum);
		});
		
		mrecall.addActionListener(e -> {
			controller.performSpecialOperation("mrecall");
			setDisplay(model.displayNum);
		});
		
		mclear.addActionListener(e -> {
			controller.performSpecialOperation("mclear");
			setDisplay(model.displayNum);
		});
		
		enter.addActionListener(e -> {
			plus.setBackground(Color.WHITE);
			minus.setBackground(Color.WHITE);
			multiply.setBackground(Color.WHITE);
			divide.setBackground(Color.WHITE);
			square.setBackground(Color.WHITE);
			sqroot.setBackground(Color.WHITE);
			mplus.setBackground(Color.WHITE);
			mminus.setBackground(Color.WHITE);
			mrecall.setBackground(Color.WHITE);
			mclear.setBackground(Color.WHITE);
			
			controller.performOperation();
			setDisplay(model.displayNum);
		});

	}		
	
	public void setDisplay(String display) {
		inputBox.setText(display);
	}
	
	// Setting sizing and layout of buttons on GUI
	public JPanel getPanel() {
        JPanel panel = new JPanel();

        panel.add(zero);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(decimal);
        panel.add(clear);
        panel.add(plus);
        panel.add(minus);
        panel.add(divide);
        panel.add(multiply);
        panel.add(mplus);
        panel.add(mminus);
        panel.add(mclear);
        panel.add(mrecall);
        panel.add(delete);
        panel.add(enter);
        panel.add(inputBox);
        panel.add(square);
        panel.add(sqroot);

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        zero.setBounds(10, 50, 40, 40);
        one.setBounds(55, 50, 40, 40);
        two.setBounds(100, 50, 40, 40);
        three.setBounds(10, 95, 40, 40);
        four.setBounds(55, 95, 40, 40);
        five.setBounds(100, 95, 40, 40);
        six.setBounds(10, 140, 40, 40);
        seven.setBounds(55, 140, 40, 40);
        eight.setBounds(100, 140, 40, 40);
        nine.setBounds(55, 185, 40, 40);
        decimal.setBounds(10, 185, 40, 40);
        clear.setBounds(100, 185, 40, 40);
        clear.setMargin(new Insets(1,1,1,1));
        plus.setBounds(145, 50, 40, 40);
        plus.setMargin(new Insets(1,1,1,1));
        minus.setBounds(145, 95, 40, 40);
        divide.setBounds(145, 140, 40, 40);
        multiply.setBounds(145, 185, 40, 40);
        mplus.setBounds(10, 230, 40, 40);
        mplus.setMargin(new Insets(1,1,1,1));
        mminus.setBounds(55, 230, 40, 40);
        mminus.setMargin(new Insets(1,1,1,1));
        mrecall.setBounds(100, 230, 40, 40);
        mrecall.setMargin(new Insets(1,1,1,1));
        mclear.setBounds(145, 230, 40, 40);
        mclear.setMargin(new Insets(1,1,1,1));
        square.setBounds(10, 275, 40, 40);
        square.setMargin(new Insets(1,1,1,1));
        sqroot.setBounds(55, 275, 40, 40);
        sqroot.setMargin(new Insets(1,1,1,1));
        delete.setBounds(100, 275, 40, 40);
        delete.setMargin(new Insets(1,1,1,1));
        enter.setBounds(145, 275, 40, 40);
        enter.setMargin(new Insets(1,1,1,1));
        inputBox.setBounds(10, 5, 175, 40);
        inputBox.setText("0");
        inputBox.setBorder(BorderFactory.createLineBorder(Color.black));

        return panel;
    }
	
	// Getters for all buttons so that I can test UI
	public JButton getZero() {
		return zero;
	}

	public JButton getOne() {
		return one;
	}

	public JButton getTwo() {
		return two;
	}

	public JButton getThree() {
		return three;
	}

	public JButton getFour() {
		return four;
	}

	public JButton getFive() {
		return five;
	}

	public JButton getSix() {
		return six;
	}

	public JButton getSeven() {
		return seven;
	}

	public JButton getEight() {
		return eight;
	}

	public JButton getNine() {
		return nine;
	}

	public JButton getDecimal() {
		return decimal;
	}

	public JButton getClear() {
		return clear;
	}

	public JButton getPlus() {
		return plus;
	}

	public JButton getMinus() {
		return minus;
	}

	public JButton getDivide() {
		return divide;
	}

	public JButton getMultiply() {
		return multiply;
	}

	public JButton getMplus() {
		return mplus;
	}

	public JButton getMminus() {
		return mminus;
	}

	public JButton getMrecall() {
		return mrecall;
	}

	public JButton getMclear() {
		return mclear;
	}

	public JButton getDelete() {
		return delete;
	}

	public JButton getEnter() {
		return enter;
	}

	public JButton getSquare() {
		return square;
	}

	public JButton getSqroot() {
		return sqroot;
	}

	
}
