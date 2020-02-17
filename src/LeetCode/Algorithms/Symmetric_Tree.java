package LeetCode.Algorithms;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/symmetric-tree/
public class Symmetric_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		System.out.println(isSymmetric(root));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		
		if (root != null) {
			q.offer(root.left);
			q.offer(root.right);
			
			while (!q.isEmpty()) {
				TreeNode tn1 = q.poll();
				TreeNode tn2 = q.poll();
				
				if (tn1 == null && tn2 == null) {
					continue;
				}
				
				if (tn1 == null || tn2 == null) {
					return false;
				}
				
				if (tn1.val != tn2.val) {
					return false;
				}
				
				q.offer(tn1.left);
				q.offer(tn2.right);
				q.offer(tn1.right);
				q.offer(tn2.left);
			}
		}
		
		return true;
	}
}