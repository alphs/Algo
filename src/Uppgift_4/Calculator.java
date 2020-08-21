package Uppgift_4;

import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

	private String buttonText[] = {"7", "8", "9", "^", "C", "4", "5", "6", "(", ")", "1", "2", "3", "*", "/", "0", "+", "-", "="};
	private JButton[] buttons = new JButton[19];
	private JTextField expressionField;
	private String exp="";

	public Calculator( ){
		super("Uppgift_4.Calculator");
		setSize(320, 240);
		expressionField = new JTextField();
		JPanel panel = new JPanel(new GridLayout(4, 5));
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonText[i]);
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		panel.add(new Label());
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(expressionField, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand() == "C"){
			exp = "";
			expressionField.setText(exp);
		}
		else if(e.getActionCommand() == "="){
			expressionField.setText(""+evaluate(infixToPostfix(exp)));
		}

		else{
			exp = exp + e.getActionCommand();
			expressionField.setText(exp);
		}

	}



	public static void main(String [] arg) {

		Calculator calc = new Calculator();
		calc.setVisible(true);

	}


	public static LinkedList<String> infixToPostfix(String exp){
		Stack<String> stack = new Stack<>();
		String number = "";
		LinkedList<String> list = new LinkedList<>();

		for(int i = 0; i < exp.length(); i++) {
			String s = exp.charAt(i) + "";

			if(s.equals("+")) {
				if(!number.equals("")) {		//checks if "number" is empty, if it isn't it will only contain numbers and therefore ads it to the list
					list.add(number);
					number = "";
				}
				while(!stack.isEmpty()) {
					String tkn = stack.pop();

					if(tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^")) {
						list.add(tkn);
					}
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);
			}

			else if (s.equals("-")) {

				if(!number.equals("")) {		//checks if "number" contains anything, if it does it will only be numbers and therefore ads it to the list
					list.add(number);
					number = "";
				}
				while(!stack.isEmpty()) {
					String tkn = stack.pop();

					if(tkn.equals("*") || tkn.equals("/") || tkn.equals("+") || tkn.equals("-") || tkn.equals("^")) {
						list.add(tkn);
					}
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);
			}

			else if (s.equals("*")) {
				if(!number.equals("")) {		//checks if "number" contains anything, if it does it will only be numbers and therefore ads it to the list
					list.add(number);
					number = "";
				}
				while(!stack.isEmpty()) {
					String tkn = stack.pop();
					if(tkn.equals("*") || tkn.equals("^")) {
						list.add(tkn);
					}
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);
			}

			else if (s.equals("/")) {
				if(!number.equals("")) {		//checks if "number" contains anything, if it does it will only be numbers and therefore ads it to the list
					list.add(number);
					number = "";
				}
				while(!stack.isEmpty()) {
					String tkn = stack.pop();
					if(tkn.equals("*") || tkn.equals("/") || tkn.equals("^")) {
						list.add(tkn);
					}
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);
			}

			else if (s.equals("^")) {
				if(!number.equals("")) {		//checks if "number" contains anything, if it does it will only be numbers and therefore ads it to the list
					list.add(number);
					number = "";
				}
				while(!stack.isEmpty()) {
					String tkn = stack.pop();
					if(tkn.equals("^")) {
						list.add(tkn);
					}
					else {
						stack.push(tkn);
						break;
					}
				}
				stack.push(s);
			}

			else if (s.equals(")"))	{
				if(!number.equals("")) {		//checks if "number" contains anyting, if it does it will only be numbers and therefore ads it to the list
					list.add(number);
					number = "";
				}
				while(!stack.isEmpty()) {
					String tkn = stack.pop();
					if(tkn.equals("(")) {
						break;
					} 
					else {
						list.add(tkn);
					}
				}
			}

			else if (s.equals("(")) {
				stack.push(s);
			}

			else if(i + 1 == exp.length()) {              
				list.add(s);
			}

			else {						//adds the previous number with the new one (to be to use numbers <9)
				number = number + s;
			}

		}
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	} 

	public static double evaluate(LinkedList<String> exp) {
		Stack<String> stack = new Stack<String>();
		String operand1;
		String operand2;
		Iterator<String> itr = exp.iterator();

		while(itr.hasNext()) {
			String x = itr.next();
			if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("^")) {
				operand1 = stack.pop();
				operand2 = stack.pop();
				stack.push(calculateExpression(x, operand1, operand2) + "");
			}
			else {
				stack.push(x);
			}
		}
		return Double.parseDouble(stack.pop());
	}

	private static double calculateExpression(String x, String operand1, String operand2) {
		if(x.equals("+")) { return Double.parseDouble(operand1) + Double.parseDouble(operand2);}	

		if(x.equals("-")) { return Double.parseDouble(operand1) - Double.parseDouble(operand2);}	

		if(x.equals("*")) { return Double.parseDouble(operand1) * Double.parseDouble(operand2);}	

		if(x.equals("/")) { return Double.parseDouble(operand1) / Double.parseDouble(operand2);}	

		if(x.equals("^")) { return Math.pow(Double.parseDouble(operand2), Double.parseDouble(operand1));}

		return 0;
		
/*		if(x.equals("+")) { return new BigDecimal(operand1).add(new BigDecimal(operand2));}	

		if(x.equals("-")) { return new BigDecimal(operand1).subtract(new BigDecimal(operand2));}	

		if(x.equals("*")) { return new BigDecimal(operand1).multiply(new BigDecimal(operand2));}	

		if(x.equals("/")) { 
			BigDecimal op1 = new BigDecimal(operand1);
			BigDecimal op2 = new BigDecimal(operand2);
			
			return (op1.divideToIntegralValue(op2)).add(op1.remainder(op2));
		}	

		//if(x.equals("^")) { return new BigDecimal(operand1).pow(new BigDecimal(operand2).intValue());}	
		if(x.equals("^")) { return new BigDecimal(Math.pow(new BigDecimal(operand1).doubleValue(), new BigDecimal(operand2).doubleValue()));}

		return new BigDecimal(0);
		*/
	}


}