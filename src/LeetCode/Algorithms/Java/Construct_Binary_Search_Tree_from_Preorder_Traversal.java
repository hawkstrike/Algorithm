package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		int[] preorder = {8, 5, 1, 7, 10, 12};
		
		System.out.println(bstFromPreorder(preorder));
	}
	
	public static TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root = new TreeNode(preorder[0]);
		
		for (int i = 1; i < preorder.length; i++) {
			int val = preorder[i];
			
			root = insertValue(root, val);
		}
		
		return root;
	}
	
	public static TreeNode insertValue(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		
		if (val < root.val) {
			root.left = insertValue(root.left, val);
		} else if (val > root.val) {
			root.right = insertValue(root.right, val);
		}
		
		return root;
	}
}