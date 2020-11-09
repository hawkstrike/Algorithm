package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
public class Maximum_Difference_Between_Node_and_Ancestor {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		
		System.out.println(maxAncestorDiff(root));
	}
	
	public static int maxAncestorDiff(TreeNode root) {
		return recurrentMaxAncestorDiff(root, root.val, root.val);
	}
	
	public static int recurrentMaxAncestorDiff(TreeNode curr, int currMax, int currMin) {
		if (curr == null) {
			return currMax - currMin;
		}
		
		currMax = Math.max(currMax, curr.val);
		currMin = Math.min(currMin, curr.val);
		
		int left = recurrentMaxAncestorDiff(curr.left, currMax, currMin);
		int right = recurrentMaxAncestorDiff(curr.right, currMax, currMin);
		
		return Math.max(left, right);
	}
}