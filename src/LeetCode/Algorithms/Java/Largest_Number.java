package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/largest-number/
public class Largest_Number {
	public static void main(String[] args) {
		int[] nums = {10, 2};
		
		System.out.println(largestNumber(nums));
	}
	
	public static String largestNumber(int[] nums) {
		int length = nums.length;
		String[] strArr = new String[length];
		
		for (int i = 0; i < length; i++) {
			strArr[i] = Integer.toString(nums[i]);
		}
		
		Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
		
		StringBuffer sb = new StringBuffer();
		
		for (String s : strArr) {
			sb.append(s);
		}
		
		return (sb.toString().startsWith("0")) ? "0" : sb.toString();
	}
}