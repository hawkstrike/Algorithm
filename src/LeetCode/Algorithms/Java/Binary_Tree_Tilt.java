package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/binary-tree-tilt/
public class Binary_Tree_Tilt {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static int totalTilt = 0;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		System.out.println(findTilt(root));
	}
	
	public static int findTilt(TreeNode root) {
		recurrentFindTilt(root);
		
		return totalTilt;
	}
	
	public static int recurrentFindTilt(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int leftSum = recurrentFindTilt(root.left);
		int rightSum = recurrentFindTilt(root.right);
		int tilt = Math.abs(leftSum - rightSum);
		
		totalTilt += tilt;
		
		return root.val + leftSum + rightSum;
	}
}