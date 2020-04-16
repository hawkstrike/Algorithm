package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/valid-parenthesis-string/
public class Valid_Parenthesis_String {
	public static void main(String[] args) {
		String s = "()";
		
		System.out.println(checkValidString(s));
	}
	
	public static boolean checkValidString(String s) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c == '(') {
				s1.push(i);
			} else if (c == ')') {
				if (!s1.isEmpty()) {
					s1.pop();
				} else if (!s2.isEmpty()) {
					s2.pop();
				} else {
					return false;
				}
			} else if (c == '*') {
				s2.push(i);
			} else {
				return false;
			}
		}
		
		while (!s1.isEmpty()) {
			if (s2.isEmpty() || s1.pop() > s2.pop()) {
				return false;
			}
		}
		
		return true;
	}
}