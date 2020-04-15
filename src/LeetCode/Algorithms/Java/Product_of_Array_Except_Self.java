package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/product-of-array-except-self/
public class Product_of_Array_Except_Self {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		
		int[] result = productExceptSelf(nums);
		
		for (int n : result) {
			System.out.println(n);
		}
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int length = nums.length;
		int[] left = new int[length];
		int[] right = new int[length];
		int[] result = new int[length];
		
		left[0] = 1;
		for (int i = 1; i < length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}
		
		right[length - 1] = 1;
		for (int i = length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}
		
		for (int i = 0; i < length; i++) {
			result[i] = left[i] * right[i];
		}
		
		return result;
	}
}