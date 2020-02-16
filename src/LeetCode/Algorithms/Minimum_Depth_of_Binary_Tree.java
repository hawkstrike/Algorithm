package LeetCode.Algorithms;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/
public class Minimum_Depth_of_Binary_Tree {
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
		root.right.left.left = new TreeNode(1);
		root.right.left.right = new TreeNode(10);
		
		System.out.println(minDepth(root));
	}
	
	public static int minDepth(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		int size = 0;
		int depth = 0;
		int result = 0;
		boolean flag = false;
		
		if (root != null) {
			q.offer(root);
			
			while (!q.isEmpty()) {
				size = q.size();
				depth++;
				
				for (int i = 0; i < size; i++) {
					TreeNode tn = q.poll();
					
					if (tn.left == null && tn.right == null) {
						result = depth;
						flag = true;
						break;
					}
					
					if (tn.left != null) {
						q.offer(tn.left);
					}
					if (tn.right != null) {
						q.offer(tn.right);
					}
				}
				
				if (flag) {
					break;
				}
			}
		}
		
		return result;
	}
	
	/*public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		
		return 1 + ((left == 0 || right == 0) ? left + right : Math.min(left, right));
	}*/
}