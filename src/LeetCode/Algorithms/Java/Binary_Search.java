package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/binary-search/
public class Binary_Search {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target = 10;
		
		System.out.println(search(nums, target));
	}
	
	public static int search(int[] nums, int target) {
		int index = Arrays.binarySearch(nums, target);
		
		return (index >= 0) ? index : -1;
	}
}