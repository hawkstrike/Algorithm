package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
public class Sum_of_Root_To_Leaf_Binary_Numbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		
		System.out.println(sumRootToLeaf(root));
	}
	
	public static int sumRootToLeaf(TreeNode root) {
		return recurrentSumRootToLeaf(root, 0);
	}
	
	public static int recurrentSumRootToLeaf(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		
		sum = (sum << 1) + root.val;
		
		if (root.left == null && root.right == null) {
			return sum;
		}
		
		return recurrentSumRootToLeaf(root.left, sum) + recurrentSumRootToLeaf(root.right, sum);
	}
}