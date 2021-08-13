package Programmers.Practice.Level2;

import java.util.Stack;

// 올바른 괄호
// https://programmers.co.kr/learn/courses/30/lessons/12909
public class Problem_12909 {
	
	public static void main(String[] args) {
		//String s = "()()";
		//String s = "(())()";
		//String s = ")()(";
		String s = "(()(";
		
		System.out.println(solution(s));
	}
	
	public static boolean solution(String s) {
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
		
		return (stack.isEmpty()) ? true : false;
	}
}