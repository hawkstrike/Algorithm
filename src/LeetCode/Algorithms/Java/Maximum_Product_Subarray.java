package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/maximum-product-subarray/
public class Maximum_Product_Subarray {
	public static void main(String[] args) {
		//int[] nums = {2, 3, -2, 4};
		int[] nums = {-2, 0, 1};
		
		System.out.println(maxProduct(nums));
	}
	
	public static int maxProduct(int[] nums) {
		int result = Integer.MIN_VALUE;
		int product = 1;
		
		for (int n : nums) {
			product *= n;
			result = Math.max(result, product);
			
			if (product == 0) {
				product = 1;
			}
		}
		
		product = 1;
		
		for (int i = nums.length - 1; i >= 0; i--) {
			product *= nums[i];
			result = Math.max(result, product);
			
			if (product == 0) {
				product = 1;
			}
		}
		
		return result;
	}
}