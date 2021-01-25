package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
public class Check_If_All_1s_Are_at_Least_Length_K_Places_Away {
	public static void main(String[] args) {
		/*int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
		int k = 2;*/
		/*int[] nums = {1, 0, 0, 1, 0, 1};
		int k = 2;*/
		/*int[] nums = {1, 1, 1, 1, 1};
		int k = 0;*/
		int[] nums = {0, 1, 0, 1};
		int k = 1;
		
		System.out.println(kLengthApart(nums, k));
	}
	
	public static boolean kLengthApart(int[] nums, int k) {
		int difference = k;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				if (difference < k) {
					return false;
				}
				
				difference = 0;
			} else {
				difference++;
			}
		}
		
		return true;
	}
}