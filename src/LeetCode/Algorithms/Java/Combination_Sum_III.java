package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/
public class Combination_Sum_III {
	public static void main(String[] args) {
		int k = 3;
		int n = 7;
		List<List<Integer>> result = combinationSum3(k, n);
		
		for (List<Integer> list : result) {
			for (int num : list) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new LinkedList<>();
		LinkedList<Integer> combList = new LinkedList<>();
		
		backtracking(result, combList, n, k, 0);
		
		return result;
	}
	
	public static void backtracking(List<List<Integer>> result, LinkedList<Integer> combList, int remain, int k, int start) {
		if (remain == 0 && combList.size() == k) {
			result.add(new LinkedList<>(combList));
			
			return;
		} else if (remain < 0 || combList.size() == k) {
			return;
		}
		
		for (int i = start; i < 9; i++) {
			combList.add(i + 1);
			backtracking(result, combList, remain - i - 1, k, i + 1);
			combList.removeLast();
		}
	}
}