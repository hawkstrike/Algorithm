package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/path-sum-iii/
public class Path_Sum_III {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		int sum = 8;
		TreeNode root = new TreeNode(10);
		
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.right.right = new TreeNode(11);
		
		System.out.println(pathSum(root, sum));
	}
	
	public static int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		
		return recurrentPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	public static int recurrentPathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		
		return ((root.val == sum) ? 1 : 0) + recurrentPathSum(root.left, sum - root.val) + recurrentPathSum(root.right, sum - root.val);
	}
}