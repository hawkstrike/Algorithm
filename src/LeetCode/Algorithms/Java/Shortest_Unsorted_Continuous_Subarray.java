package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
public class Shortest_Unsorted_Continuous_Subarray {
	public static void main(String[] args) {
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		
		System.out.println(findUnsortedSubarray(nums));
	}
	
	public static int findUnsortedSubarray(int[] nums) {
		int[] arr = nums.clone();
		int start = arr.length;
		int end = 0;
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != nums[i]) {
				start = Math.min(start, i);
				end = Math.max(end, i);
			}
		}
		
		return (end - start >= 0) ? end - start + 1 : 0;
	}
}