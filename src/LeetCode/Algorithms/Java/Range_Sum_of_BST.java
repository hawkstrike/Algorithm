package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/range-sum-of-bst/
public class Range_Sum_of_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		int L = 7; // 6;
		int R = 15; // 10;
		
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);
		
		/*root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(18);
		root.left.left.left = new TreeNode(1);
		root.left.right.left = new TreeNode(6);*/
		
		System.out.println(rangeSumBST(root, L, R));
	}
	
	public static int rangeSumBST(TreeNode root, int L, int R) {
		return recurrentRangeSumBST(root, L, R, 0);
	}
	
	public static int recurrentRangeSumBST(TreeNode root, int L, int R, int sum) {
		if (root == null) {
			return 0;
		}
		
		if (root.val >= L && root.val <= R) {
			sum += root.val;
		}
		
		if (root.left != null) {
			sum = recurrentRangeSumBST(root.left, L, R, sum);
		}
		
		if (root.right != null) {
			sum = recurrentRangeSumBST(root.right, L, R, sum);
		}
		
		return sum;
	}
	
	/*public static int rangeSumBST(TreeNode root, int L, int R) {
		int result = 0;
		Queue<TreeNode> q = new LinkedList<>();
		
		if (root != null) {
			q.offer(root);
			
			while (!q.isEmpty()) {
				TreeNode curr = q.poll();
				
				if (curr.val >= L && curr.val <= R) {
					result += curr.val;
				}
				
				if (curr.left != null) {
					q.offer(curr.left);
				}
				
				if (curr.right != null) {
					q.offer(curr.right);
				}
			}
		}
		
		return result;
	}*/
}