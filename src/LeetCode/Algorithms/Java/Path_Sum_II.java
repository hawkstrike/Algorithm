package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/
public class Path_Sum_II {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		int sum = -5; // 22;
		TreeNode root = new TreeNode(-2);
		
		root.right = new TreeNode(-3);
		/*TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);*/
		
		List<List<Integer>> result = pathSum(root, sum);
		
		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new LinkedList<>();
		
		if (root != null) {
			recurrentPathSum(root, result, new LinkedList<>(), sum, 0);
		}
		
		return result;
	}
	
	public static void recurrentPathSum(TreeNode root, List<List<Integer>> result, List<Integer> list, int sum, int curr) {
		if (root == null) {
			return;
		}
		
		List<Integer> tempList = new LinkedList<>();
		
		tempList.addAll(list);
		curr += root.val;
		tempList.add(root.val);
		
		if (curr == sum && root.left == null && root.right == null) {
			result.add(tempList);
			
			return;
		}
		
		recurrentPathSum(root.left, result, tempList, sum, curr);
		recurrentPathSum(root.right, result, tempList, sum, curr);
	}
}