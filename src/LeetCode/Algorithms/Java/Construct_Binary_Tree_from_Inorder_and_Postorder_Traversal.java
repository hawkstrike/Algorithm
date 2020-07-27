package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	static int index = 0;
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args) {
		int[] inorder = {9, 3, 15, 20, 7};
		int[] postorder = {9, 15, 7, 20, 3};
		TreeNode result = buildTree(inorder, postorder);
		
		System.out.println();
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		
		for (int i = 0; i < inorder.length; i++) {
			hashMap.put(inorder[i], i);
		}
		
		index = postorder.length - 1;
		
		return recurrentBuildTree(hashMap, inorder, postorder, 0, postorder.length - 1);
	}
	
	public static TreeNode recurrentBuildTree(HashMap<Integer, Integer> hashMap, int[] inorder, int[] postorder, int start, int end) {
		if (start > end) {
			return null;
		}
		
		TreeNode root = new TreeNode(postorder[index--]);
		int position = hashMap.get(root.val);
		
		root.right = recurrentBuildTree(hashMap, inorder, postorder, position + 1, end);
		root.left = recurrentBuildTree(hashMap, inorder, postorder, start, position - 1);
		
		return root;
	}
}