package LeetCode.Algorithms.Java;

import java.util.Hashtable;

// https://leetcode.com/problems/delete-node-in-a-linked-list/
public class Delete_Node_in_a_Linked_List {
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			this.val = x;
		}
	}
	public static void main(String[] args) {
		ListNode root = new ListNode(4);
		
		root.next = new ListNode(5);
		root.next.next = new ListNode(1);
		root.next.next.next = new ListNode(9);
		
		ListNode node = new ListNode(5);
		
		deleteNode(node);
	}
	
	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}