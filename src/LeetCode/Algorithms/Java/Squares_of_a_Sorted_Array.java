package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array/
public class Squares_of_a_Sorted_Array {
	public static void main(String[] args) {
		//int[] nums = {-4, -1, 0, 3, 10};
		int[] nums = {-7, -3, 2, 3, 11};
		int[] result = sortedSquares(nums);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] sortedSquares(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) Math.pow(nums[i], 2);
		}
		
		Arrays.sort(nums);
		
		return nums;
	}
}