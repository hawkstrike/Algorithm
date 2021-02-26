package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/validate-stack-sequences/
public class Validate_Stack_Sequences {
	public static void main(String[] args) {
		int[] pushed = {1, 2, 3, 4, 5};
		int[] popped = {4, 5, 3, 2, 1};
		
		System.out.println(validateStackSequences(pushed, popped));
	}
	
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int length = pushed.length;
		int index = 0;
		
		for (int n : pushed) {
			stack.add(n);
			
			while (!stack.isEmpty() && index < length && stack.peek() == popped[index]) {
				stack.pop();
				index++;
			}
		}
		
		return index == length;
	}
}