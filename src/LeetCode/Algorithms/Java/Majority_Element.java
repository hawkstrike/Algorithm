package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/majority-element/
public class Majority_Element {
	public static void main(String[] args) {
		int[] nums = {2, 2, 1, 1, 1, 2, 2}; // {3, 2, 3};
		
		System.out.println(majorityElement(nums));
	}
	
	public static int majorityElement(int[] nums) {
		int count = 0;
		int compare = 0;
		
		for (int n : nums) {
			if (count == 0) {
				compare = n;
			}
			
			count += (n == compare) ? 1 : -1;
		}
		
		return compare;
		/*Arrays.sort(nums);
		
		return nums[nums.length / 2];*/
		/*HashMap<Integer, Integer> hashMap = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		int standard = nums.length / 2;
		
		for (int n : nums) {
			if (!hashMap.containsKey(n)) {
				list.add(n);
			}
			
			hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
		}
		
		for (int n : list) {
			if (hashMap.get(n) > standard) {
				return n;
			}
		}
		
		return -1;*/
	}
}