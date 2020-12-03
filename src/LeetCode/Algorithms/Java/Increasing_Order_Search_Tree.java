package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/increasing-order-search-tree/
public class Increasing_Order_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {
		
		}
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		
		TreeNode result = increasingBST(root);
		
		printTreeNode(result);
	}
	
	public static TreeNode increasingBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		List<Integer> list = new LinkedList<>();
		
		recurrentIncreasingBST(root, list);
		
		TreeNode result = new TreeNode(0);
		TreeNode curr = result;
		
		for (int n : list) {
			curr.right = new TreeNode(n);
			curr = curr.right;
		}
		
		return result.right;
	}
	
	public static void recurrentIncreasingBST(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		recurrentIncreasingBST(root.left, list);
		list.add(root.val);
		recurrentIncreasingBST(root.right, list);
	}
	
	public static void printTreeNode(TreeNode root) {
		if (root == null) {
			return;
		}
		
		printTreeNode(root.left);
		System.out.println(root.val);
		printTreeNode(root.right);
	}
}