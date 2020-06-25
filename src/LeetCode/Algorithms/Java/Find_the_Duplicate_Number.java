package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/find-the-duplicate-number/
public class Find_the_Duplicate_Number {
	public static void main(String[] args) {
		//int[] nums = {1, 3, 4, 2, 2};
		int[] nums = {3, 1, 3, 4, 2};
		
		System.out.println(findDuplicate(nums));
	}
	
	public static int findDuplicate(int[] nums) {
		int tortoise = nums[0];
		int hare = nums[0];
		
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (tortoise != hare);
		
		tortoise = nums[0];
		
		while (tortoise != hare) {
			tortoise = nums[tortoise];
			hare = nums[hare];
		}
		
		return hare;
		
		/*HashSet<Integer> hashSet = new HashSet<>();
		
		for (int n : nums) {
			if (hashSet.contains(n)) {
				return n;
			}
			
			hashSet.add(n);
		}
		
		return 0;*/
	}
}