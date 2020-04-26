package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/jump-game/
public class Jump_Game {
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		
		System.out.println(canJump(nums));
	}
	
	public static boolean canJump(int[] nums) {
		int last = nums.length - 1;
		
		for (int i = nums.length - 2; i >= 0; i--) {
			if (i + nums[i] >= last) {
				last = i;
			}
		}
		
		return last == 0;
	}
}