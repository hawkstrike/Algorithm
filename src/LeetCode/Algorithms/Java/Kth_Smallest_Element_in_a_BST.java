package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class Kth_Smallest_Element_in_a_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {
		
		}
		
		TreeNode(int val) {
			this.val = val;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) {
		/*int k = 1;
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);*/
		int k = 3;
		TreeNode root = new TreeNode(5);
		
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		
		System.out.println(kthSmallest(root, k));
	}
	
	public static int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		inOrderLoop(root, list);
		
		return list.get(k - 1);
	}
	
	public static void inOrderLoop(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		
		if (root.left != null) {
			inOrderLoop(root.left, list);
		}
		
		list.add(root.val);
		
		if (root.right != null) {
			inOrderLoop(root.right, list);
		}
	}
}