package Uppgift_4;

import java.util.*;

public class InfixToPostfixProgram {

	@SuppressWarnings("Duplicates")
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		Scanner input = new Scanner(System.in);
		String exp = input.next();
		LinkedList<String> list = new LinkedList<String>();
		String number = "";

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

		System.out.println(list);
	}
}

