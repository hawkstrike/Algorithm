package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class Subarray_Sum_Equals_K {
	public static void main(String[] args) {
		int[] nums = {1, 1, 1};
		int k = 2;
		
		System.out.println(subarraySum(nums, k));
	}
	
	public static int subarraySum(int[] nums, int k) {
		int result = 0;
		int sum = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		hashMap.put(0, 1);
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			if (hashMap.containsKey(sum - k)) {
				result += hashMap.get(sum - k);
			}
			
			hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
		}
		
		return result;
		
		/*for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				
				if (sum == k) {
					result++;
				}
			}
		}
		
		return result;*/
	}
}