package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class Binary_Tree_Preorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		List<Integer> list = preorderTraversal(root);
		
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		
		if(root != null) {
			s.push(root);
			
			while(!s.isEmpty()) {
				TreeNode tn = s.pop();
				list.add(tn.val);
				
				if(tn.right != null) {
					s.push(tn.right);
				}
				
				if(tn.left != null) {
					s.push(tn.left);
				}
			}
		}
		
		return list;
	}
}