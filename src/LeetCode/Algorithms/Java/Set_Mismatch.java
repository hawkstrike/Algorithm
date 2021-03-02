package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/set-mismatch/
public class Set_Mismatch {
	public static void main(String[] args) {
		//int[] nums = {1, 2, 2, 4};
		int[] nums = {1, 1};
		int[] result = findErrorNums(nums);
		
		for (int n : result) {
			System.out.println(n);
		}
	}
	
	public static int[] findErrorNums(int[] nums) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int duplicate = -1;
		int missing = 1;
		int length = nums.length;
		
		for (int n : nums) {
			hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
		}
		
		for (int i = 1; i <= length; i++) {
			if (hashMap.containsKey(i)) {
				if (hashMap.get(i) == 2) {
					duplicate = i;
				}
			} else {
				missing = i;
			}
		}
		
		return new int[]{duplicate, missing};
	}
}