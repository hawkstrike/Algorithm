package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class Insert_into_a_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		int val = 5;
		TreeNode root = new TreeNode(4);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		TreeNode result = insertIntoBST(root, val);
		
		printTreeNode(result);
	}
	
	public static TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		
		if (root.val > val) {
			root.left = insertIntoBST(root.left, val);
		} else {
			root.right = insertIntoBST(root.right, val);
		}
		
		return root;
	}
	
	public static void printTreeNode(TreeNode root) {
		if (root == null) {
			return;
		}
		
		System.out.println(root.val);
		
		if (root.left != null) {
			printTreeNode(root.left);
		}
		
		if (root.right != null) {
			printTreeNode(root.right);
		}
	}
}