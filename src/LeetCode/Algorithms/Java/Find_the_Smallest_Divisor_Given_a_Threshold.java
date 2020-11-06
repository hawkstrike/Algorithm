package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class Find_the_Smallest_Divisor_Given_a_Threshold {
	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 9};
		int threshold = 6;
		
		System.out.println(smallestDivisor(nums, threshold));
	}
	
	public static int smallestDivisor(int[] nums, int threshold) {
		int left = 1;
		int right = nums[nums.length - 1];
		
		while (left <= right) {
			int pivot = left + ((right - left) >> 1);
			int num = computeSum(nums, pivot);
			
			if (num > threshold) {
				left = pivot + 1;
			} else {
				right = pivot - 1;
			}
		}
		
		return left;
	}
	
	public static int computeSum(int[] nums, int x) {
		int sum = 0;
		
		for (int n : nums) {
			sum += n / x + ((n % x == 0) ? 0 : 1);
		}
		
		return sum;
	}
}