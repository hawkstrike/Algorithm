package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/longest-harmonious-subsequence/
public class Longest_Harmonious_Subsequence {
	public static void main(String[] args) {
		int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
		
		System.out.println(findLHS(nums));
	}
	
	public static int findLHS(int[] nums) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int result = 0;
		
		for (int n : nums) {
			hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
		}
		
		for (int key : hashMap.keySet()) {
			if (hashMap.containsKey(key + 1)) {
				result = Math.max(result, hashMap.get(key) + hashMap.get(key + 1));
			}
		}
		
		return result;
	}
}