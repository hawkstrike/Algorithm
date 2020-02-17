package LeetCode.Algorithms;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/symmetric-tree/
public class Path_Sum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
		
		int sum = 22;
		
		System.out.println(hasPathSum(root, sum));
	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		Queue<TreeNode> q = new LinkedList<>();
		//Queue<Integer> sumQueue = new LinkedList<>();
		
		if (root != null) {
			q.offer(root);
			//sumQueue.offer(0);
			
			while (!q.isEmpty()) {
				TreeNode tn = q.poll();
				//int currSum = sumQueue.poll() + tn.val;
				
				/*if (currSum == sum && tn.left == null && tn.right == null) {
					return true;
				}*/
				
				if (tn.val == sum && tn.left == null && tn.right == null) {
					return true;
				}
				
				if (tn.left != null) {
					tn.left.val += tn.val;
					q.offer(tn.left);
					//sumQueue.offer(currSum);
				}
				
				if (tn.right != null) {
					tn.right.val += tn.val;
					q.offer(tn.right);
					//sumQueue.offer(currSum);
				}
			}
		}
		
		return false;
	}
}