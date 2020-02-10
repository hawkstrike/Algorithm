package LeetCode.Algorithms;

import java.util.HashMap;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class Two_Sum_II_Input_array_is_sorted {
	public static void main(String[] args) {
		int[] numbers = {5, 25, 75}; // {2, 7, 11, 15}; // {-5, -4, -3, -2, -1};
		int target = 100;

		int[] result = twoSum(numbers, target);

		for(int x : result) {
			System.out.print(x + " ");
		}
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;
		
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			
			if (sum == target) {
				return new int[]{left + 1, right + 1};
			}
			
			if (sum > target) {
				right--;
			} else {
				left++;
			}
		}
		
		return new int[]{};
	}
}