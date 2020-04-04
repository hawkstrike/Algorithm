package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/single-number/
public class Single_Number {
	public static void main(String[] args) {
		int[] nums = {2, 2, 1};
		
		System.out.println(singleNumber(nums));
	}
	
	public static int singleNumber(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		
		for (int i : nums) {
			if (hashSet.contains(i)) {
				hashSet.remove(i);
			} else {
				hashSet.add(i);
			}
		}
		
		return (int) hashSet.toArray()[0];
	}
}