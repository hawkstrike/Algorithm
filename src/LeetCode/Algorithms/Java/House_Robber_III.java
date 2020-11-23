package LeetCode.Algorithms.Java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/house-robber-iii/
public class House_Robber_III {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		
		System.out.println(rob(root));
	}
	
	public static int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		HashMap<Integer, LinkedList<Integer>> graphMap = new HashMap<>();
		
		graphMap.put(-1, new LinkedList<>());
		
		int index = -1;
		Queue<TreeNode> qNode = new LinkedList<>();
		Queue<Integer> qIndex = new LinkedList<>();
		
		qNode.offer(root);
		qIndex.offer(index);
		
		while (!qNode.isEmpty()) {
			TreeNode curr = qNode.poll();
			int parentIndex = qIndex.poll();
			
			if (curr != null) {
				index++;
				list.add(curr.val);
				graphMap.put(index, new LinkedList<>());
				graphMap.get(parentIndex).add(index);
				
				qNode.offer(curr.left);
				qIndex.offer(index);
				qNode.offer(curr.right);
				qIndex.offer(index);
			}
		}
		
		int[] dpRob = new int[index + 1];
		int[] dpNotRob = new int[index + 1];
		
		for (int i = index; i >= 0; i--) {
			LinkedList<Integer> childrenList = graphMap.get(i);
			
			if (childrenList == null || childrenList.size() == 0) {
				dpRob[i] = list.get(i);
				dpNotRob[i] = 0;
			} else {
				dpRob[i] = list.get(i);
				
				for (int child : childrenList) {
					dpRob[i] += dpNotRob[child];
					dpNotRob[i] += Math.max(dpRob[child], dpNotRob[child]);
				}
			}
		}
		
		return Math.max(dpRob[0], dpNotRob[0]);
	}
}