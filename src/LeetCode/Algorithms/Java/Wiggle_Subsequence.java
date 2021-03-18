package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/wiggle-subsequence/
public class Wiggle_Subsequence {
	public static void main(String[] args) {
		int[] nums = {1, 7, 4, 9, 2, 5};
		
		System.out.println(wiggleMaxLength(nums));
	}
	
	public static int wiggleMaxLength(int[] nums) {
		int length = nums.length;
		
		if (length < 2) {
			return length;
		}
		
		int down = 1;
		int up = 1;
		
		for (int i = 1; i < length; i++) {
			if (nums[i] > nums[i - 1]) {
				up = down + 1;
			} else if (nums[i] < nums[i - 1]) {
				down = up + 1;
			}
		}
		
		return Math.max(down, up);
	}
}