package com.greatlearning.balancingbrackets;

import java.util.Stack;

public class BalancingBrackets {

	public static boolean hasBalancedBrackets(String brkts) {
		Stack<Character> brackets = new Stack<Character>();
		char temp;
		for (int i = 0; i < brkts.length(); i++) {
			temp = brkts.charAt(i);

			if (temp == '(' || temp == '[' || temp == '{') {
				brackets.push(temp);
				continue;
			}
			if (brackets.isEmpty()) {
				return false;
			}
			
			temp = brackets.pop();

			if (brkts.charAt(i) == ')' && temp != '(')
				return false;
			else if (brkts.charAt(i) == ']' && temp != '[')
				return false;
			else if (brkts.charAt(i) == '}' && temp != '{')
				return false;

		}

		if (brackets.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String inputString = "([[{}]]))";
		if (hasBalancedBrackets(inputString)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}

}
