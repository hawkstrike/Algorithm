package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/subarray-product-less-than-k/
public class Subarray_Product_Less_Than_K {
	public static void main(String[] args) {
		int[] nums = {10, 5, 2, 6};
		int k = 100;
		
		System.out.println(numSubarrayProductLessThanK(nums, k));
	}
	
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		
		int product = 1;
		int result = 0;
		int left = 0;
		
		for (int right = 0; right < nums.length; right++) {
			product *= nums[right];
			
			while (product >= k) {
				product /= nums[left++];
			}
			
			result += right - left + 1;
		}
		
		return result;
	}
}