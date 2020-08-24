package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/sum-of-left-leaves/
public class Sum_of_Left_Leaves {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(sumOfLeftLeaves(root));
	}
	
	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return recurrentSumOfLeftLeaves(root, 0, false);
	}
	
	public static int recurrentSumOfLeftLeaves(TreeNode root, int sum, boolean left) {
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null && left) {
			sum += root.val;
			
			return sum;
		}
		
		return recurrentSumOfLeftLeaves(root.left, sum, true) + recurrentSumOfLeftLeaves(root.right, sum, false);
	}
}