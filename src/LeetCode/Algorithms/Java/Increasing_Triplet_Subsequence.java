package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/increasing-triplet-subsequence/
public class Increasing_Triplet_Subsequence {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		
		System.out.println(increasingTriplet(nums));
	}
	
	public static boolean increasingTriplet(int[] nums) {
		if (nums.length <= 2) {
			return false;
		}
		
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		
		for (int n : nums) {
			if (n < first) {
				first = n;
			} else if (n > first && n < second) {
				second = n;
			} else if (n > second) {
				return true;
			}
		}
		
		return false;
	}
}