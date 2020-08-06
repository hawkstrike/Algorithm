package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class Find_All_Duplicates_in_an_Array {
	public static void main(String[] args) {
		int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
		List<Integer> result = findDuplicates(nums);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		
		System.out.println();
	}
	
	public static List<Integer> findDuplicates(int[] nums) {
		int[] frequency = new int[nums.length + 1];
		List<Integer> list = new ArrayList<>();
		
		for (int n : nums) {
			frequency[n]++;
		}
		
		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] == 2) {
				list.add(i);
			}
		}
		
		return list;
		
		/*Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				list.add(nums[i]);
				i++;
			}
		}
		
		return list;*/
	}
}