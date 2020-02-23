package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/invert-binary-tree/
public class Invert_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		
		invertTree(root);
		
		System.out.println();
	}
	
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode currLeft = invertTree(root.left);
		TreeNode currRight = invertTree(root.right);
		
		root.left = currRight;
		root.right = currLeft;
		
		return root;
	}
	
	/*public static TreeNode invertTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		
		if (root != null) {
			q.offer(root);
		}
		
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			TreeNode temp = curr.left;
			
			curr.left = curr.right;
			curr.right = temp;
			
			if (curr.left != null) {
				q.offer(curr.left);
			}
			
			if (curr.right != null) {
				q.offer(curr.right);
			}
		}
		
		return root;
	}*/
}