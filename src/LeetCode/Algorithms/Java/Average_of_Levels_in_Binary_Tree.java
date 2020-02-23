package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class Average_of_Levels_in_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(3); // 6,2,7,1,4,null,8,null,null,3,5,9
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<Double> list = averageOfLevels(root);
		
		for (double i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new LinkedList<Double>();
		Queue<TreeNode> q = new LinkedList<>();
		int size = 0;
		
		if (root != null) {
			q.offer(root);
			size = q.size();
		}
		
		while (!q.isEmpty()) {
			double sum = 0;
			int i = 0;
			
			for (i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				
				if (curr.left != null) {
					q.offer(curr.left);
				}
				
				if (curr.right != null) {
					q.offer(curr.right);
				}
				
				sum += curr.val;
			}
			
			size = q.size();
			result.add(sum / i);
		}
		
		return result;
	}
}