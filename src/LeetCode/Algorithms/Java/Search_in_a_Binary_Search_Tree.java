package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/search-in-a-binary-search-tree/
public class Search_in_a_Binary_Search_Tree {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		int val = 2;
		TreeNode root = new TreeNode(4);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		TreeNode result = searchBST(root, val);

		System.out.println(searchBST(root, val));
	}
	
	public static TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		
		if (root.val == val) {
			return root;
		} else if (root.val > val) {
			return searchBST(root.left, val);
		} else {
			return searchBST(root.right, val);
		}
	}
}