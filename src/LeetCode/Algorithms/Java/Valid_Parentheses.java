package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class Valid_Parentheses {
	public static void main(String[] args) {
		//String s = "()";
		//String s = "{[}]";
		String s = "({[)";
		
		System.out.println(isValid(s));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] cArr = s.toCharArray();
		
		for (char c : cArr) {
			if (!stack.isEmpty()) {
				if (c == ')' && stack.peek() == '(') {
					stack.pop();
				} else if (c == '}' && stack.peek() == '{') {
					stack.pop();
				} else if (c == ']' && stack.peek() == '[') {
					stack.pop();
				} else {
					stack.add(c);
				}
			} else {
				stack.add(c);
			}
		}
		
		return stack.isEmpty();
	}
}