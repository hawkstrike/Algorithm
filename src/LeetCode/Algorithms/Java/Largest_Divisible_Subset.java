package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/largest-divisible-subset/
public class Largest_Divisible_Subset {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<Integer> result = largestDivisibleSubset(nums);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		if(nums.length == 0) {
			return new ArrayList<>();
		}
		
		int[] dp = new int[nums.length];
		int[] prev = new int[nums.length];
		int max = 1;
		int index = 0;
		
		Arrays.fill(dp, 1);
		Arrays.fill(prev, -1);
		Arrays.sort(nums);
		
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						prev[i] = j;
					}
				}
			}
			
			if (dp[i] > max) {
				max = dp[i];
				index = i;
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		while (index != -1) {
			result.add(nums[index]);
			index = prev[index];
		}
		
		return result;
	}
}