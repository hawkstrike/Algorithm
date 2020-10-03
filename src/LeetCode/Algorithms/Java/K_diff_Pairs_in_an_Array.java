package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/
public class K_diff_Pairs_in_an_Array {
	public static void main(String[] args) {
		/*int[] nums = {3, 1, 4, 1, 5};
		int k = 2;*/
		int[] nums = {1, 2, 3, 4, 5};
		int k = 1;
		
		System.out.println(findPairs(nums, k));
	}
	
	public static int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		
		int left = 0;
		int right = 1;
		int length = nums.length;
		int result = 0;
		
		while (left < length && right < length) {
			int diff = nums[right] - nums[left];
			
			if (diff > k) {
				left++;
			} else if (diff < k || left == right) {
				right++;
			} else {
				left++;
				result++;
				
				while (left < length && nums[left] == nums[left - 1]) {
					left++;
				}
			}
		}
		
		return result;
		
		/*HashSet<String> hashSet = new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int diff = Math.abs(nums[i] - nums[j]);
				
				if (diff == k) {
					int min = Math.min(nums[i], nums[j]);
					int max = Math.max(nums[i], nums[j]);
					
					hashSet.add(min + "," + max);
				}
			}
		}
		
		return hashSet.size();*/
	}
}