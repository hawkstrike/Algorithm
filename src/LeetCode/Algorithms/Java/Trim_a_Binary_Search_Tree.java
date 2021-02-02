package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/trim-a-binary-search-tree/
public class Trim_a_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(1);
		int low = 1;
		int high = 2;
		
		root.left = new TreeNode(0);
		root.right = new TreeNode(2);*/
		TreeNode root = new TreeNode(3);
		int low = 1;
		int high = 3;
		
		root.left = new TreeNode(0);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		
		TreeNode result = trimBST(root, low, high);
		
		printTreeNode(result);
	}
	
	public static TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null) {
			return null;
		}
		
		if (root.val > high) {
			return trimBST(root.left, low, high);
		}
		if (root.val < low) {
			return trimBST(root.right, low, high);
		}
		
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		
		return root;
	}
	
	public static void printTreeNode(TreeNode curr) {
		if (curr == null) {
			return;
		}
		
		printTreeNode(curr.left);
		System.out.println(curr.val);
		printTreeNode(curr.right);
	}
}