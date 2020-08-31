package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/delete-node-in-a-bst/
public class Delete_Node_in_a_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		int key = 3;
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(7);
		
		TreeNode result = deleteNode(root, key);
		
		printValue(result);
	}
	
	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		
		if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else if (root.val < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null || root.right == null) {
				root = (root.left == null) ? root.right : root.left;
			} else {
				TreeNode curr = root.right;
				
				while (curr.left != null) {
					curr = curr.left;
				}
				
				root.val = curr.val;
				root.right = deleteNode(root.right, curr.val);
			}
		}
		
		return root;
	}
	
	
	public static void printValue(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			
			printValue(root.left);
			printValue(root.right);
		}
	}
}