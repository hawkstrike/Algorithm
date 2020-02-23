package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class Maximum_Depth_of_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(maxDepth(root));
	}
	
	/*public static int maxDepth(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		int size = 0;
		int depth = 0;
		
		if (root != null) {
			q.offer(root);
			
			while (!q.isEmpty()) {
				size = q.size();
				depth++;
				
				for (int i = 0; i < size; i++) {
					TreeNode tn = q.poll();
					
					if (tn.left != null) {
						q.offer(tn.left);
					}
					if (tn.right != null) {
						q.offer(tn.right);
					}
				}
			}
		}
		
		return depth;
	}*/
	
	public static int maxDepth(TreeNode root) {
		return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}