package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-longest-increasing-subsequence/
public class Number_of_Longest_Increasing_Subsequence {
	public static void main(String[] args) {
		//int[] nums = {1, 3, 5, 4, 7};
		int[] nums = {2, 2, 2, 2, 2};
		
		System.out.println(findNumberOfLIS(nums));
	}
	
	public static int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] dp = new int[nums.length];
		int[] countArr = new int[nums.length];
		
		Arrays.fill(dp, 1);
		
		int result = 0;
		int max = 0;
		
		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[i] < dp[j] + 1) {
						count = countArr[j];
						dp[i] = dp[j] + 1;
					} else if (dp[i] == dp[j] + 1) {
						count += countArr[j];
					}
				}
			}
			
			countArr[i] = count;
			
			if (dp[i] > max) {
				result = count;
				max = dp[i];
			} else if (max == dp[i]) {
				result += count;
			}
		}
		
		return result;
		
		/*int length = nums.length;
		
		if (length <= 1) {
			return length;
		}
		
		int[] dp = new int[length];
		int[] countArr = new int[length];
		
		Arrays.fill(countArr, 1);
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (dp[j] >= dp[i]) {
						dp[i] = dp[j] + 1;
						countArr[i] = countArr[j];
					} else if (dp[j] + 1 == dp[i]) {
						countArr[i] += countArr[j];
					}
				}
			}
		}
		
		int longest = 0;
		int result = 0;
		
		for (int n : dp) {
			longest = Math.max(longest, n);
		}
		
		for (int i = 0; i < length; i++) {
			if (dp[i] == longest) {
				result += countArr[i];
			}
		}
		
		return result;*/
	}
}