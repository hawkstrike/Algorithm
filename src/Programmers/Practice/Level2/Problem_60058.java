package Programmers.Practice.Level2;

import java.util.Stack;

// 괄호 변환
// https://programmers.co.kr/learn/courses/30/lessons/60058
public class Problem_60058 {
	
	public static void main(String[] args) {
		//String p = "(()())()";
		//String p = ")(";
		//String p = "()))((()";
		String p = ")()()()(";
		
		System.out.println(solution(p));
	}
	
	public static String solution(String p) {
		if (isRight(p)) {
			return p;
		}
		
		return recurrent(p);
	}
	
	public static String recurrent(String p) {
		if ("".equals(p)) {
			return p;
		}
		
		int index = findIndex(p);
		String u = p.substring(0, index);
		String v = p.substring(index);
		
		if (isRight(u)) {
			return u + recurrent(v);
		} else {
			StringBuffer sb = new StringBuffer();
			
			sb.append("(").append(recurrent(v)).append(")");
			
			for (int i = 1; i < u.length() - 1; i++) {
				char c = (u.charAt(i) == '(') ? ')' :'(';
				
				sb.append(c);
			}
			
			return sb.toString();
		}
	}
	
	public static int findIndex(String s) {
		char[] arr = s.toCharArray();
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				count++;
			} else {
				count--;
			}
			
			if (count == 0) {
				return i + 1;
			}
		}
		
		return 0;
	}
	
	public static boolean isRight(String s) {
		Stack<Character> stack = new Stack<>();
		char[] arr = s.toCharArray();
		
		for (char c : arr) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else if (stack.peek() == '(' && c == ')') {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		
		return (stack.isEmpty()) ? true: false;
	}
}