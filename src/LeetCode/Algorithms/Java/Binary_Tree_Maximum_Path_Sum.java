package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class Binary_Tree_Maximum_Path_Sum {
	static int max = Integer.MIN_VALUE;
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		
		TreeNode(int val) {
			this.val = val;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);*/
		
		/*TreeNode root = new TreeNode(-10);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);*/
		
//		TreeNode root = new TreeNode(-3);
		
		TreeNode root = new TreeNode(0);
		
		System.out.println(maxPathSum(root));
	}
	
	public static int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		recurrentMaxPathSum(root);
		
		return max;
	}
	
	public static int recurrentMaxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = Math.max(recurrentMaxPathSum(root.left), 0);
		int right = Math.max(recurrentMaxPathSum(root.right), 0);
		
		max = Math.max(max, root.val + left + right);
		
		System.out.println("root.val : " + root.val);
		System.out.println("left : " + left);
		System.out.println("right : " + right);
		System.out.println("max : " + max);
		System.out.println("-----------------------------------");
		
		return root.val + Math.max(left, right);
	}
}