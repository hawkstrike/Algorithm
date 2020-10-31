package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/recover-binary-search-tree/
public class Recover_Binary_Search_Tree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		
		recoverTree(root);
	}
	
	public static void recoverTree(TreeNode root) {
		TreeNode first = null;
		TreeNode second = null;
		TreeNode previous = new TreeNode(Integer.MIN_VALUE);
		
		while (root != null) {
			TreeNode node = root.left;
			
			if (node != null) {
				while (node.right != null && node.right != root) {
					node = node.right;
				}
				
				if (node.right == null) {
					node.right = root;
					root = root.left;
					
					continue;
				} else {
					node.right = null;
				}
			}
			
			if (root.val < previous.val) {
				if (first == null) {
					first = previous;
				}
				
				second = root;
			}
			
			previous = root;
			root = root.right;
		}
		
		int temp = second.val;
		
		second.val = first.val;
		first.val = temp;
	}
}