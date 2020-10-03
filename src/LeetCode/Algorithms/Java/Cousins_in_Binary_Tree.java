package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/cousins-in-binary-tree/
public class Cousins_in_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
		
		}
		
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
		int x = 5; // 4;
		int y = 4; // 3;
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		/*TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);*/
		
		System.out.println(isCousins(root, x, y));
	}
	
	public static boolean isCousins(TreeNode root, int x, int y) {
		Queue<TreeNode> q = new LinkedList<>();
		int compareX = -1;
		int compareY = -2;
		int depth = 1;
		
		q.offer(root);
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				
				if (curr.left != null && curr.right != null) {
					if ((curr.left.val == x || curr.left.val == y) && (curr.right.val == x || curr.right.val == y)) {
						return false;
					}
				}
				
				if (compareX == compareY) {
					return true;
				}
				
				if (curr.val == x) {
					compareX = depth;
				}
				
				if (curr.val == y) {
					compareY = depth;
				}
				
				if (curr.left != null) {
					q.offer(curr.left);
				}
				
				if (curr.right != null) {
					q.offer(curr.right);
				}
			}
			
			depth++;
		}
		
		return compareX == compareY;
	}
}