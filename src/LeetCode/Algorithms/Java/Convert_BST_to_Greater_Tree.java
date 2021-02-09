package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/convert-bst-to-greater-tree/
public class Convert_BST_to_Greater_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int sum = 0;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		
		TreeNode result = convertBST(root);
		
		printTreeNode(result);
	}
	
	public static TreeNode convertBST(TreeNode root) {
		if (root != null) {
			convertBST(root.right);
			sum += root.val;
			root.val = sum;
			convertBST(root.left);
		}
		
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