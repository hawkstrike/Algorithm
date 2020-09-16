package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
public class Maximum_XOR_of_Two_Numbers_in_an_Array {
	public static void main(String[] args) {
		int[] nums = {3, 10, 5, 25, 2, 8};
		
		System.out.println(findMaximumXOR(nums));
	}
	
	public static int findMaximumXOR(int[] nums) {
		Arrays.sort(nums);
		
		int result = 0;
		int orOper = 0;
		
		for (int n : nums) {
			orOper |= n;
		}
		
		int i = 0;
		int j = nums.length - 1;
		
		while (i < j) {
			result = Math.max(result, nums[i] ^ nums[j]);
			
			if ((orOper ^ nums[i]) > nums[j]) {
				i++;
			} else {
				j--;
			}
		}
		
		return result;
	}
}