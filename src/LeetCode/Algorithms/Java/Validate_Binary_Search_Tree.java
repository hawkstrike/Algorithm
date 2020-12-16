package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/validate-binary-search-tree/
public class Validate_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(2);
		
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);*/
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);
		
		System.out.println(isValidBST(root));
	}
	
	public static boolean isValidBST(TreeNode root) {
		return recurrentIsValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	public static boolean recurrentIsValidBST(TreeNode curr, long min, long max) {
		if (curr == null) {
			return true;
		}
		
		if (curr.val <= min || curr.val >= max) {
			return false;
		}
		
		return recurrentIsValidBST(curr.left, min, curr.val) && recurrentIsValidBST(curr.right, curr.val, max);
	}
}