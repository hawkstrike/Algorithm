package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class Kth_Largest_Element_in_an_Array {
	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;
		/*int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		int k = 4;*/
		
		System.out.println(findKthLargest(nums, k));
	}
	
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		
		int max = Integer.MAX_VALUE;
		
		for (int i = nums.length - 1; i >= 0 && k > 0; i--) {
			
			if (max >= nums[i]) {
				max = nums[i];
				k--;
			}
		}
		
		return max;
	}
}