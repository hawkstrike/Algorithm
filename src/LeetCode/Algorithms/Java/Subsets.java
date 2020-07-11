package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> result = subsets(nums);
		
		for (List<Integer> list : result) {
			for (int n : list) {
				System.out.print(n + " ");
			}
			
			System.out.println();
		}
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		
		backtracking(result, new ArrayList<>(), nums, 0);
		
		return result;
		/*List<List<Integer>> result = new ArrayList<>();
		int length = nums.length;
		
		for (int i = (int) Math.pow(2, length); i < (int) Math.pow(2, length + 1); i++) {
			String bitmask = Integer.toBinaryString(i).substring(1);
			List<Integer> list = new ArrayList<>();
			
			for (int j = 0; j < length; j++) {
				if (bitmask.charAt(j) == '1') {
					list.add(nums[j]);
				}
			}
			
			result.add(list);
		}
		
		return result;*/
	}
	
	public static void backtracking(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
		result.add(new ArrayList<>(list));
		
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			backtracking(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
}