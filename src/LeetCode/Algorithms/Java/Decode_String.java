package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/
public class Decode_String {
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		
		System.out.println(decodeString(s));
	}
	
	public static String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (char c : s.toCharArray()) {
			if (c != ']') {
				stack.push(c);
			} else {
				StringBuffer sb = new StringBuffer();
				
				while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
					sb.insert(0, stack.pop());
				}
				
				String subStr = sb.toString();
				stack.pop();
				
				sb = new StringBuffer();
				
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					sb.insert(0, stack.pop());
				}
				
				int count = Integer.parseInt(sb.toString());
				
				while (count-- > 0) {
					for (char ch : subStr.toCharArray()) {
						stack.push(ch);
					}
				}
			}
		}
		
		StringBuffer result = new StringBuffer();
		
		while (!stack.isEmpty()) {
			result.insert(0, stack.pop());
		}
		
		return result.toString();
	}
}