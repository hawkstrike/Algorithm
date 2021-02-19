package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class Minimum_Remove_to_Make_Valid_Parentheses {
	public static class Parenthesis {
		int index;
		char c;
		
		public Parenthesis(int index, char c) {
			this.index = index;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		
		System.out.println(minRemoveToMakeValid(s));
	}
	
	public static String minRemoveToMakeValid(String s) {
		StringBuffer sb = new StringBuffer();
		Stack<Parenthesis> stack = new Stack<>();
		char[] arr = s.toCharArray();
		boolean[] flag = new boolean[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			
			if (c == '(') {
				stack.add(new Parenthesis(i, c));
			} else if (c == ')') {
				if (!stack.isEmpty() && stack.peek().c == '(') {
					flag[stack.pop().index] = true;
					flag[i] = true;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			
			if ((c == '(' || c == ')') && !flag[i]) {
				continue;
			}
			
			sb.append(c);
		}
		
		return sb.toString();
	}
}