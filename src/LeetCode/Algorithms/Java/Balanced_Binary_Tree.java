package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/balanced-binary-tree/
public class Balanced_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root) {
		return recurrentIsBalanced(root) >= 0 ? true : false;
	}
	
	public static int recurrentIsBalanced(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = recurrentIsBalanced(root.left);
		int right = recurrentIsBalanced(root.right);
		
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		
		return Math.max(left, right) + 1;
	}
}