package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/house-robber/
public class House_Robber {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		
		System.out.println(rob(nums));
	}
	
	public static int rob(int[] nums) {
		int[] dp = new int[nums.length + 2];
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(nums[i - 2] + dp[i - 2], dp[i - 1]);
		}
		
		return dp[nums.length + 1];
	}
}