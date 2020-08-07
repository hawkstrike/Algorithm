package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class Vertical_Order_Traversal_of_a_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> result = verticalTraversal(root);
		
		for (List<Integer> list : result) {
			for (int n : list) {
				System.out.print(n + " ");
			}
			
			System.out.println();
		}
	}
	
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
		
		recurrentVerticalTraversal(root, treeMap, 0, 0);
		
		for (List<int[]> list : treeMap.values()) {
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
				}
			});
			
			List<Integer> valueList = new ArrayList<>();
			
			for (int[] arr : list) {
				valueList.add(arr[1]);
			}
			
			result.add(valueList);
		}
		
		return result;
	}
	
	public static void recurrentVerticalTraversal(TreeNode root, TreeMap<Integer, List<int[]>> treeMap, int x, int y) {
		if (root == null) {
			return;
		}
		
		treeMap.putIfAbsent(x, new ArrayList<>());
		treeMap.get(x).add(new int[]{y, root.val});
		
		recurrentVerticalTraversal(root.left, treeMap, x - 1, y - 1);
		recurrentVerticalTraversal(root.right, treeMap, x + 1, y - 1);
	}
}