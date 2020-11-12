package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class Permutations_II {
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		List<List<Integer>> result = permuteUnique(nums);
		
		for (List<Integer> list : result) {
			for (int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		
		Arrays.sort(nums);
		List<List<Integer>> list = new LinkedList<>();
		
		recurrentPermuteUnique(list, new LinkedList<>(), nums, visited);
		
		return list;
	}
	
	public static void recurrentPermuteUnique(List<List<Integer>> list, List<Integer> pathList, int[] nums, boolean[] visited) {
		if (pathList.size() == nums.length) {
			list.add(pathList);
			
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
				continue;
			}
			
			List<Integer> nextPathList = new LinkedList<>(pathList);
			
			nextPathList.add(nums[i]);
			visited[i] = true;
			recurrentPermuteUnique(list, nextPathList, nums, visited);
			visited[i] = false;
		}
	}
}