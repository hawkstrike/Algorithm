package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
public class Sum_of_Nodes_with_Even_Valued_Grandparent {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(6);
		
		root.left = new TreeNode(7);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(9);
		root.left.right.left = new TreeNode(1);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(5);*/
		
		TreeNode root = new TreeNode(61);
		
		root.left = new TreeNode(13);
		root.right = new TreeNode(46);
		root.right.right = new TreeNode(56);
		root.right.right.left = new TreeNode(72);
		
		System.out.println(sumEvenGrandparent(root));
	}
	
	public static int sumEvenGrandparent(TreeNode root) {
		int result = findEvenGrandparent(root, 0);
		
		return result;
	}
	
	public static int findEvenGrandparent(TreeNode root, int sum) {
		if (root == null) {
			return sum;
		}
		
		if (root.val % 2 == 0) {
			sum += getGrandchild(root.left);
			sum += getGrandchild(root.right);
		}
		
		sum = findEvenGrandparent(root.left, sum);
		sum = findEvenGrandparent(root.right, sum);
		
		return sum;
	}
	
	public static int getGrandchild(TreeNode child) {
		int sum = 0;
		
		if (child == null) {
			return 0;
		}
		
		if (child.left != null) {
			sum += child.left.val;
		}
		
		if (child.right != null) {
			sum += child.right.val;
		}
		
		return sum;
	}
}