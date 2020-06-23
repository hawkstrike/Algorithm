package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/count-complete-tree-nodes/
public class Count_Complete_Tree_Nodes {
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
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		
		System.out.println(countNodes(root));
	}
	
	public static int countNodes(TreeNode root) {
		return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	/*public static int countNodes(TreeNode root) {
		int left = leftHeight(root);
		int right = rightHeight(root);
		
		return (left == right) ? (1 << left) - 1 : 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	public static int leftHeight(TreeNode root) {
		return root == null ? 0 : 1 + leftHeight(root.left);
	}
	
	public static int rightHeight(TreeNode root) {
		return root == null ? 0 : 1 + rightHeight(root.right);
	}*/
}