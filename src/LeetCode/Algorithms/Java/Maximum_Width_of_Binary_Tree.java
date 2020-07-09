package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-width-of-binary-tree/
public class Maximum_Width_of_Binary_Tree {
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
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		
		System.out.println(widthOfBinaryTree(root));
	}
	
	public static int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		LinkedList<TreeNode> list = new LinkedList<>();
		int maxLevel = 1;
		
		root.val = 0;
		list.add(root);
		
		while (!list.isEmpty()) {
			int size = list.size();
			
			maxLevel = Math.max(maxLevel, list.peekLast().val - list.peekFirst().val + 1);
			
			for (int i = 0; i < size; i++) {
				root = list.poll();
				
				if (root.left != null) {
					root.left.val = root.val * 2;
					list.add(root.left);
				}
				
				if (root.right != null) {
					root.right.val = root.val * 2 + 1;
					list.add(root.right);
				}
			}
		}
		
		return maxLevel;
	}
}