package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class Populating_Next_Right_Pointers_in_Each_Node {
	public static class Node {
		int val;
		Node left;
		Node right;
		Node next;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		Node result = connect(root);
	}
	
	public static Node connect(Node root) {
		if (root == null) {
			return null;
		}
		
		Queue<Node> q = new LinkedList<>();
		
		q.offer(root);
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			while (size != 0) {
				size--;
				
				Node node = q.poll();
				
				if (size == 0) {
					node.next = null;
				} else {
					node.next = q.peek();
				}
				
				if (node.left != null) {
					q.offer(node.left);
				}
				
				if (node.right != null) {
					q.offer(node.right);
				}
			}
		}
		
		return root;
	}
}