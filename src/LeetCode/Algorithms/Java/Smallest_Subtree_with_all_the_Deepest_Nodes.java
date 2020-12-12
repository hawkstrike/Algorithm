package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
public class Smallest_Subtree_with_all_the_Deepest_Nodes {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static class AdvanceTreeNode {
		TreeNode node;
		int distance;
		
		public AdvanceTreeNode(TreeNode node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		TreeNode result = subtreeWithAllDeepest(root);
		
		printTreeNode(result);
	}
	
	public static TreeNode subtreeWithAllDeepest(TreeNode root) {
		return recurrentSubtreeWithAllDeepest(root).node;
	}
	
	public static AdvanceTreeNode recurrentSubtreeWithAllDeepest(TreeNode root) {
		if (root == null) {
			return new AdvanceTreeNode(null, 0);
		}
		
		AdvanceTreeNode left = recurrentSubtreeWithAllDeepest(root.left);
		AdvanceTreeNode right = recurrentSubtreeWithAllDeepest(root.right);
		
		if (left.distance > right.distance) {
			return new AdvanceTreeNode(left.node, left.distance + 1);
		}
		
		if (left.distance < right.distance) {
			return new AdvanceTreeNode(right.node, right.distance + 1);
		}
		
		return new AdvanceTreeNode(root, left.distance + 1);
	}
	
	public static void printTreeNode(TreeNode curr) {
		if (curr == null) {
			return;
		}
		
		System.out.println(curr.val);
		printTreeNode(curr.left);
		printTreeNode(curr.right);
	}
}