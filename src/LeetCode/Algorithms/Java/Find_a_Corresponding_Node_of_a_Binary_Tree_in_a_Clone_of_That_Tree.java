package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode original = new TreeNode(7);
		
		original.left = new TreeNode(4);
		original.right = new TreeNode(3);
		original.right.left = new TreeNode(6);
		original.right.right = new TreeNode(19);
		
		TreeNode cloned = new TreeNode(7);
		
		cloned.left = new TreeNode(4);
		cloned.right = new TreeNode(3);
		cloned.right.left = new TreeNode(6);
		cloned.right.right = new TreeNode(19);
		
		TreeNode target = new TreeNode(3);
		
		TreeNode result = getTargetCopy(original, cloned, target);
		
		printTreeNode(result);
	}
	
	public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		Queue<TreeNode> originalQueue = new LinkedList<>();
		Queue<TreeNode> clonedQueue = new LinkedList<>();
		
		originalQueue.offer(original);
		clonedQueue.offer(cloned);
		
		while (!originalQueue.isEmpty()) {
			TreeNode currOriginal = originalQueue.poll();
			TreeNode currCloned = clonedQueue.poll();
			
			if (currOriginal == target) {
				return currCloned;
			}
			
			if (currOriginal.left != null) {
				originalQueue.offer(currOriginal.left);
				clonedQueue.offer(currCloned.left);
			}
			
			if (currOriginal.right != null) {
				originalQueue.offer(currOriginal.right);
				clonedQueue.offer(currCloned.right);
			}
		}
		
		return null;
	}
	
	public static void printTreeNode(TreeNode curr) {
		if (curr == null) {
			return;
		}
		
		printTreeNode(curr.left);
		System.out.println(curr.val);
		printTreeNode(curr.right);
	}
}