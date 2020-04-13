package LeetCode.Algorithms.Java;

import java.util.Hashtable;

// https://leetcode.com/problems/contiguous-array/
public class Contiguous_Array {
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1}; // {0, 1};
		
		System.out.println(findMaxLength(nums));
	}
	
	public static int findMaxLength(int[] nums) {
		int result = 0, count = 0;
		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		
		hashtable.put(0, -1);
		
		for (int i = 0; i < nums.length; i++) {
			count += (nums[i] == 1) ? 1 : -1;
			
			if (hashtable.containsKey(count)) {
				result = Math.max(result, i - hashtable.get(count));
			} else {
				hashtable.put(count, i);
			}
		}
		
		return result;
	}
}