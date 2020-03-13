package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/deepest-leaves-sum/
public class Deepest_Leaves_Sum {
	static int deepest = 0;
	static int totalSum = 0;
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);
		
		System.out.println(deepestLeavesSum(root));
	}
	
	public static int deepestLeavesSum(TreeNode root) {
		findDeepestLeaves(root, 1);
		
		return totalSum;
	}
	
	public static void findDeepestLeaves(TreeNode root, int depth) {
		if (root != null && depth > deepest) {
			deepest = depth;
			totalSum = root.val;
		} else if (depth == deepest) {
			totalSum += root.val;
		}
		
		if (root.left != null) {
			findDeepestLeaves(root.left, depth + 1);
		}
		
		if (root.right != null) {
			findDeepestLeaves(root.right, depth + 1);
		}
	}

	/*public static int deepestLeavesSum(TreeNode root) {
		int result = 0;
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		q.offer(root);
		
		while (!q.isEmpty()) {
			int sum = 0;
			int size = q.size();
			
			while (size > 0) {
				TreeNode curr = q.poll();
				
				if (curr.left != null) {
					q.offer(curr.left);
				}
				
				if (curr.right != null) {
					q.offer(curr.right);
				}
				
				sum += curr.val;
				size--;
			}
			
			list.add(sum);
		}
		
		result = list.get(list.size() - 1);
		
		return result;
	}*/
}