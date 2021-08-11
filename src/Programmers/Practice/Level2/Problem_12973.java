package Programmers.Practice.Level2;

import java.util.Stack;

// 짝지어 제거하기
// https://programmers.co.kr/learn/courses/30/lessons/12973
public class Problem_12973 {
	
	public static void main(String[] args) {
		//String s = "baabaa";
		String s = "cdcd";
		
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		char[] arr = s.toCharArray();
		//int length = s.length();
		
		for (char c : arr) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else if (stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		
		/*if (length > 0) {
			stack.push(0);
		}
		
		for (int i = 1; i < length; i++) {
			if (s.charAt(stack.peek()) == s.charAt(i)) {
				stack.pop();
			} else {
				stack.push(i);
			}
			
			if (stack.isEmpty() && i + 1 < length) {
				stack.push(i + 1);
				i++;
			}
		}*/
		
		return (stack.isEmpty()) ? 1 : 0;
	}
}