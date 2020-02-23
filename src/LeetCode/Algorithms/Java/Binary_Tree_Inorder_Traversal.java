package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/
public class Binary_Tree_Inorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(6); // 6,2,7,1,4,null,8,null,null,3,5,9
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		
		List<Integer> list = inorderTraversal(root);
		
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		inOrderLoop(root, list);
		
		return list;
		
		/*Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode tn = root;
		
		while (tn != null || !s.isEmpty()) {
			while (tn != null) {
				s.push(tn);
				tn = tn.left;
			}
			
			tn = s.pop();
			list.add(tn.val);
			tn = tn.right;
		}
		
		return list;*/
		
		/*if(root != null) {
			s.push(root);
			
			while(!s.isEmpty()) {
				TreeNode tn = s.pop();
				flag = true;
				
				if(tn.right != null || (tn.right != null && !s.isEmpty() && s.peek() != tn.right)) {
					TreeNode tnRight = tn.right;
					tn.right = null;
					
					s.push(tnRight);
					flag = false;
					
					if (tn.left == null) {
						flag = true;
					}
				}
				
				if(tn.left != null) {
					TreeNode tnLeft = tn.left;
					tn.left = null;
					
					s.push(tn);
					s.push(tnLeft);
					flag = false;
				}
				
				if (flag) {
					list.add(tn.val);
				}
			}
		}
		
		return list;*/
	}
	
	public static void inOrderLoop(TreeNode root, List<Integer> list) {
		if (root != null) {
			if (root.left != null) {
				inOrderLoop(root.left, list);
			}
			
			list.add(root.val);
			
			if (root.right != null) {
				inOrderLoop(root.right, list);
			}
		}
	}
}