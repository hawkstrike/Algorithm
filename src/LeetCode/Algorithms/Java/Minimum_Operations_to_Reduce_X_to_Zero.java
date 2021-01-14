package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
public class Minimum_Operations_to_Reduce_X_to_Zero {
	public static void main(String[] args) {
		int[] nums = {1, 1, 4, 2, 3};
		int x = 5;
		
		System.out.println(minOperations(nums, x));
	}
	
	public static int minOperations(int[] nums, int x) {
		int total = 0;
		int length = nums.length;
		int max = -1;
		int left = 0;
		int curr = 0;
		
		for (int n : nums) {
			total += n;
		}
		
		for (int right = 0; right < length; right++) {
			curr += nums[right];
			
			while (curr > total - x && left <= right) {
				curr -= nums[left];
				left++;
			}
			
			if (curr == total - x) {
				max = Math.max(max, right - left + 1);
			}
		}
		
		return (max != -1) ? length - max : -1;
	}
}