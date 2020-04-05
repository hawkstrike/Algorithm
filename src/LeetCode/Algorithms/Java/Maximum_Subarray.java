package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/maximum-subarray/
public class Maximum_Subarray {
	public static void main(String[] args) {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			max = Math.max(max, sum);
		}
		
		return max;
		
		/*int result = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			int max = nums[i];
			int sum = nums[i];
			
			for (int j = i + 1; j < nums.length; j++) {
				sum += nums[j];
				max = Math.max(max, sum);
			}
			
			result = Math.max(result, max);
		}
		
		return result;*/
	}
}