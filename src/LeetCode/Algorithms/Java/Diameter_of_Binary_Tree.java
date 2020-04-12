package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class Diameter_of_Binary_Tree {
	static int diameter = 0;
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}

	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);*/
		
		TreeNode root = new TreeNode(4);
		
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.left.right.right = new TreeNode(5);
		
		System.out.println(diameterOfBinaryTree(root));
	}
	
	public static int diameterOfBinaryTree(TreeNode root) {
		recurrentDiameterOfBinaryTree(root);
		
		return diameter;
	}
	
	public static int recurrentDiameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = recurrentDiameterOfBinaryTree(root.left);
		int right = recurrentDiameterOfBinaryTree(root.right);
		
		diameter = Math.max(diameter, left + right);
		
		return 1 + Math.max(left, right);
	}
}