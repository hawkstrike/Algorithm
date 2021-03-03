package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/missing-number/
public class Missing_Number {
	public static void main(String[] args) {
		int[] nums = {3, 0, 1};
		
		System.out.println(missingNumber(nums));
	}
	
	public static int missingNumber(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		int length = nums.length;
		
		for (int n : nums) {
			hashSet.add(n);
		}
		
		
		for (int i = 0; i <= length; i++) {
			if (!hashSet.contains(i)) {
				return i;
			}
		}
		
		return -1;
		
		/*int missing = nums.length;
		
		for (int i = 0; i < nums.length; i++) {
			missing ^= i ^ nums[i];
		}
		
		return missing;*/
		
		/*int expectedSum = nums.length * (nums.length + 1) / 2;
		int actualSum = 0;
		
		for (int n : nums) {
			actualSum += n;
		}
		
		return expectedSum - actualSum;*/
	}
}