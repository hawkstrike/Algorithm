package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/burst-balloons/
public class Burst_Balloons {
	public static void main(String[] args) {
		int[] nums = {3, 1, 5, 8};
		
		System.out.println(maxCoins(nums));
	}
	
	public static int maxCoins(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		int length = nums.length;
		int[][] dp = new int[length][length];
		
		for (int i = length - 1; i >= 0; i--) {
			for (int j = i; j <= length - 1; j++) {
				for (int k = i; k <= j; k++) {
					int coin = 0;
					
					coin += (k == i) ? 0 : dp[i][k - 1];
					coin += (k == j) ? 0 : dp[k + 1][j];
					coin += ((i == 0) ? 1 : nums[i - 1]) * nums[k] * ((j == length - 1) ? 1 : nums[j + 1]);
					dp[i][j] = Math.max(dp[i][j], coin);
				}
			}
		}
		
		return dp[0][length - 1];
	}
}