package Programmers.SkillCheck.Java;

import java.util.Stack;

public class Level2_1 {
	
	public static void main(String[] args) {
		String s = "()()";
		
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