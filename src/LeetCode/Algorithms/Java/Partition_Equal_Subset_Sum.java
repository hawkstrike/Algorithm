package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/partition-equal-subset-sum/
public class Partition_Equal_Subset_Sum {
	public static void main(String[] args) {
		int[] nums = {1, 5, 11, 5};
		
		System.out.println(canPartition(nums));
	}
	
	public static boolean canPartition(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		
		int totalSum = 0;
		
		for (int n : nums) {
			totalSum += n;
		}
		
		if (totalSum % 2 != 0) {
			return false;
		}
		
		int subSetSum = totalSum / 2;
		boolean[] dp = new boolean[subSetSum + 1];
		
		dp[0] = true;
		
		for (int n : nums) {
			for (int i = subSetSum; i >= n; i--) {
				dp[i] |= dp[i - n];
			}
		}
		
		return dp[subSetSum];
	}
}