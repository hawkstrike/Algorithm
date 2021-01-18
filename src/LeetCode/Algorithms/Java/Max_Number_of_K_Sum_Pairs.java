package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/
public class Max_Number_of_K_Sum_Pairs {
	public static void main(String[] args) {
		/*int[] nums = {1, 2, 3, 4};
		int k = 5;*/
		int[] nums = {3, 1, 3, 4, 3};
		int k = 6;
		
		System.out.println(maxOperations(nums, k));
	}
	
	public static int maxOperations(int[] nums, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int result = 0;
		
		for (int n : nums) {
			if (hashMap.containsKey(k - n)) {
				int count = hashMap.get(k - n);
				
				if (count == 1) {
					hashMap.remove(k - n);
				} else {
					hashMap.put(k - n, count - 1);
				}
				
				result++;
			} else {
				hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
			}
		}
		
		return result;
	}
}