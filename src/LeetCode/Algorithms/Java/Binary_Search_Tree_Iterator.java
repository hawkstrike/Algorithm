package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/binary-search-tree-iterator/
public class Binary_Search_Tree_Iterator {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static class BSTIterator {
		Stack<Integer> stack = new Stack();
		
		public BSTIterator(TreeNode root) {
			recurrentSetStack(root);
		}
		
		public int next() {
			return stack.pop();
		}
		
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		
		private void recurrentSetStack(TreeNode curr) {
			if (curr == null) {
				return;
			}
			
			recurrentSetStack(curr.right);
			stack.add(curr.val);
			recurrentSetStack(curr.left);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);
		
		BSTIterator bstIterator = new BSTIterator(root);
		
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
	}
}