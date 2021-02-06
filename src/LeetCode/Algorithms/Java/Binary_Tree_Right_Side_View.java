package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/
public class Binary_Tree_Right_Side_View {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		
		List<Integer> result = rightSideView(root);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		if (root != null) {
			queue.offer(root);
		}
		
		int size = queue.size();
		
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			
			if (curr.left != null) {
				queue.offer(curr.left);
			}
			
			if (curr.right != null) {
				queue.offer(curr.right);
			}
			
			size--;
			
			if (size == 0) {
				size = queue.size();
				list.add(curr.val);
			}
		}
		
		return list;
	}
}