package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class How_Many_Numbers_Are_Smaller_Than_the_Current_Number {
	public static void main(String[] args) {
		int[] nums = {8, 1, 2, 2, 3};
		int[] result = smallerNumbersThanCurrent(nums);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int length = nums.length;
		int[] result = new int[length];
		int[] cloneNums = nums.clone();
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		Arrays.sort(cloneNums);
		
		for (int i = 0; i < length; i++) {
			if (!hashMap.containsKey(cloneNums[i])) {
				hashMap.put(cloneNums[i], i);
			}
		}
		
		for (int i = 0; i < length; i++) {
			result[i] = hashMap.get(nums[i]);
		}
		
		return result;
		/*int[] result = new int[nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			
			for (int n : nums) {
				if (nums[i] > n) {
					count++;
				}
			}
			
			result[i] = count;
		}
		
		return result;*/
	}
}