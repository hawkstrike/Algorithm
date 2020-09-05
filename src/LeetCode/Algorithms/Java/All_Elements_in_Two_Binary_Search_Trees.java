package LeetCode.Algorithms.Java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
public class All_Elements_in_Two_Binary_Search_Trees {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*TreeNode root1 = new TreeNode(2);
		TreeNode root2 = new TreeNode(1);
		
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(4);
		root2.left = new TreeNode(0);
		root2.right = new TreeNode(3);*/
		TreeNode root1 = new TreeNode(0);
		TreeNode root2 = new TreeNode(5);
		
		root1.left = new TreeNode(-10);
		root1.right = new TreeNode(10);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(7);
		root2.left.left = new TreeNode(0);
		root2.left.right = new TreeNode(2);
		
		List<Integer> result = getAllElements(root1, root2);
		
		for (int n : result) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> list = new LinkedList<>();
		
		addAllElements(root1, list);
		addAllElements(root2, list);
		
		Collections.sort(list);
		
		return list;
	}
	
	public static void addAllElements(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		list.add(root.val);
		
		addAllElements(root.left, list);
		addAllElements(root.right, list);
	}
}