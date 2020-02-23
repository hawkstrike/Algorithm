package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class Binary_Tree_Level_Order_Traversal_II {
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
		
		List<List<Integer>> list = levelOrder(root);
		
		for (List<Integer> l : list) {
			for (int i : l) {
				System.out.print(i + " ");
			}
			
			System.out.println();
		}
		System.out.println();
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		Queue<TreeNode> q = new LinkedList<>();
		
		if (root != null) {
			q.add(root);
			
			while (!q.isEmpty()) {
				List<Integer> list = new LinkedList<>();
				int size = q.size();
				
				for (int i = 0; i < size; i++) {
					TreeNode tn = q.poll();
					
					if (tn.left != null) {
						q.add(tn.left);
					}
					
					if (tn.right != null) {
						q.add(tn.right);
					}
					
					list.add(tn.val);
				}
				
				result.addFirst(list);
			}
		}
		
		return result;
	}
}