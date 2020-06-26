package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class Sum_Root_to_Leaf_Numbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);*/
		TreeNode root = new TreeNode(4);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		/*TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(0);*/
		
		System.out.println(sumNumbers(root));
	}
	
	public static int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		return recurrentSumNumbers(root, 0);
	}
	
	public static int recurrentSumNumbers(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		
		sum *= 10;
		sum += root.val;
		
		if (root.left == null && root.right == null) {
			return sum;
		}
		
		return recurrentSumNumbers(root.left, sum) + recurrentSumNumbers(root.right, sum);
	}
}