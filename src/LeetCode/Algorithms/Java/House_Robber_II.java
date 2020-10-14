package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/house-robber-ii/
public class House_Robber_II {
	public static void main(String[] args) {
//		int[] nums = {2, 3, 2};
		int[] nums = {1, 2, 3, 1};
		
		System.out.println(rob(nums));
	}
	
	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		
		int[] dp1 = new int[nums.length + 1];
		int[] dp2 = new int[nums.length + 1];
		
		dp1[1] = nums[0];
		
		for (int i = 2; i <= nums.length; i++) {
			dp1[i] = Math.max(nums[i - 1] + dp1[i - 2], dp1[i - 1]);
			dp2[i] = Math.max(nums[i - 1] + dp2[i - 2], dp2[i - 1]);
		}
		
		return Math.max(dp1[nums.length - 1], dp2[nums.length]);
	}
}