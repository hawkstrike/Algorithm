package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/single-number-ii/
public class Single_Number_II {
	public static void main(String[] args) {
		//int[] nums = {2, 2, 3, 2};
		int[] nums = {4, 1, 2, 1, 2};
		
		System.out.println(singleNumber(nums));
	}
	
	public static int singleNumber(int[] nums) {
		int first = 0;
		int second = 0;
		
		for (int i = 0; i < nums.length; i++) {
			first = ~second & (first ^ nums[i]);
			second = ~first & (second ^ nums[i]);
		}
		
		return first;
	}
}