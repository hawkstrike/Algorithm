package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/move-zeroes/
public class Move_Zeroes {
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		
		moveZeroes(nums);
	}
	
	public static void moveZeroes(int[] nums) {
		int index = 0;
		
		for (int n : nums) {
			if (n != 0) {
				nums[index++] = n;
			}
		}
		
		for (int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}