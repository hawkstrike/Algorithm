package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
public class Pseudo_Palindromic_Paths_in_a_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int count = 0;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		
		System.out.println(pseudoPalindromicPaths(root));
	}
	
	public static int pseudoPalindromicPaths(TreeNode root) {
		preOrder(root, 0);
		
		return count;
	}
	
	public static void preOrder(TreeNode node, int path) {
		if (node != null) {
			path = path ^ (1 << node.val);
			
			if (node.left == null && node.right == null) {
				if ((path & (path - 1)) == 0) {
					count++;
				}
			}
			
			preOrder(node.left, path);
			preOrder(node.right, path);
		}
	}
}