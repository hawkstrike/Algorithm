package LeetCode.Algorithms.Java;

import java.util.TreeSet;

// https://leetcode.com/problems/contains-duplicate-iii/
public class Contains_Duplicate_III {
	public static void main(String[] args) {
		/*int[] nums = {1, 2, 3, 1};
		int k = 3;
		int t = 0;*/
		int[] nums = {1, 0, 1, 1};
		int k = 1;
		int t = 2;
		
		System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
	}
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k < 1 || t < 0) {
			return false;
		}
		
		TreeSet<Long> treeSet = new TreeSet<>();
		
		treeSet.add((long) nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			if (i > k) {
				treeSet.remove((long) nums[i - k - 1]);
			}
			
			long left = (long) nums[i] - t;
			long right = (long) nums[i] + t;
			
			if (left <= right && !treeSet.subSet(left, right + 1).isEmpty()) {
				return true;
			}
			
			treeSet.add((long) nums[i]);
		}
		
		return false;
	}
}