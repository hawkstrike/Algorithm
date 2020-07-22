package LeetCode.Algorithms.Java;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class Binary_Tree_Zigzag_Level_Order_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> list = zigzagLevelOrder(root);
		
		for (List<Integer> l : list) {
			for (int i : l) {
				System.out.print(i + " ");
			}
			
			System.out.println();
		}
		System.out.println();
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		Deque<TreeNode> dq = new LinkedList<>();
		boolean left = true;
		
		if (root != null) {
			dq.addFirst(root);
			
			while (!dq.isEmpty()) {
				LinkedList<Integer> list = new LinkedList<>();
				int size = dq.size();
				
				for (int i = 0; i < size; i++) {
					TreeNode tn = dq.removeFirst();
					
					if (tn.left != null) {
						dq.addLast(tn.left);
					}
					
					if (tn.right != null) {
						dq.addLast(tn.right);
					}
					
					if (left) {
						list.addLast(tn.val);
					} else {
						list.addFirst(tn.val);
					}
					
				}
				
				left = !left;
				result.add(list);
			}
		}
		
		return result;
	}
}