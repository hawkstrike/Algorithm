package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
public class Flip_Binary_Tree_To_Match_Preorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(1);
		int[] voyage = {2, 1};
		
		root.left = new TreeNode(2);*/
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int[] voyage = {1, 3, 2};
		
		List<Integer> result = flipMatchVoyage(root, voyage);
		
		for (int n : result) {
			System.out.println(n);
		}
	}
	
	public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		List<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		int i = 0;
		
		stack.push(root);
		
		while (stack.size() > 0) {
			TreeNode curr = stack.pop();
			
			if (curr == null) {
				continue;
			}
			
			if (curr.val != voyage[i++]) {
				return Arrays.asList(-1);
			}
			
			if (curr.right != null && curr.right.val == voyage[i]) {
				if (curr.left != null) {
					result.add(curr.val);
				}
				
				stack.push(curr.left);
				stack.push(curr.right);
			} else {
				stack.push(curr.right);
				stack.push(curr.left);
			}
		}
		
		return result;
	}
}