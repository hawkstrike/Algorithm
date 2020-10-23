package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/132-pattern/
public class Pattern_132 {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		
		System.out.println(find132pattern(nums));
	}
	
	public static boolean find132pattern(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int second = Integer.MIN_VALUE;
		
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < second) {
				return true;
			}
			
			while (!stack.isEmpty() && nums[i] > stack.peek()) {
				second = stack.pop();
			}
			
			stack.push(nums[i]);
		}
		
		return false;
	}
}