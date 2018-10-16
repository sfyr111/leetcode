package com.leetcode;

import java.util.Stack;

/**
 * Created by yangran
 * 2018/10/4
 */

public class VaildParentheses20 {

	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;
				char topChar = stack.pop();
				if (c == ')' && topChar != '(')
					return false;
				if (c == ']' && topChar != '[')
					return false;
				if (c == '}' && topChar != '{')
					return false;
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()[]{}"));
	}
}
