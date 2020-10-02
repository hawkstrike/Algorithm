package LeetCode.Algorithms.Java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class Combination_Sum {
	public static void main(String[] args) {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		/*int[] candidates = {2, 3, 5};
		int target = 8;*/
		/*int[] candidates = {2};
		int target = 1;*/
		/*int[] candidates = {1};
		int target = 2;*/
		List<List<Integer>> result = combinationSum(candidates, target);
		
		for (List<Integer> list : result) {
			for (int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	/*public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new LinkedList<>();
		
		for (int i = 0; i < candidates.length; i++) {
			List<Integer> list = new LinkedList<>();
			
			list.add(candidates[i]);
			backtrackingCombinationSum(result, list, candidates, target, candidates[i], i);
		}
		
		return result;
	}
	
	public static void backtrackingCombinationSum(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int sum, int index) {
		if (index >= candidates.length || sum > target) {
			return;
		}
		
		if (target == sum) {
			result.add(list);
			
			return;
		}
		
		for (int i = index; i < candidates.length; i++) {
			List<Integer> tempList = new LinkedList<>(list);
			tempList.add(candidates[i]);
			backtrackingCombinationSum(result, tempList, candidates, target, sum + candidates[i], i);
		}
	}*/
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		HashSet<List<Integer>> hashSet = new HashSet<>();
		
		for (int i = 0; i < candidates.length; i++) {
			List<Integer> list = new LinkedList<>();
			
			list.add(candidates[i]);
			backtrackingCombinationSum(hashSet, list, candidates, target - candidates[i], i);
		}
		
		return new LinkedList<>(hashSet);
	}
	
	public static void backtrackingCombinationSum(HashSet<List<Integer>> hashSet, List<Integer> list, int[] candidates, int target, int index) {
		if (index >= candidates.length || target < 0) {
			return;
		}
		
		if (target == 0) {
			hashSet.add(list);
			
			return;
		}
		
		for (int i = index; i < candidates.length; i++) {
			List<Integer> tempList = new LinkedList<>(list);
			
			tempList.add(candidates[i]);
			backtrackingCombinationSum(hashSet, tempList, candidates, target - candidates[i], i);
		}
	}
}