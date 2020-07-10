package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class Flatten_a_Multilevel_Doubly_Linked_List {
	public static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
		
		Node(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		
		head.next = new Node(2);
		head.next.prev = head;
		head.next.next = new Node(3);
		head.next.next.prev = head.next;
		head.next.next.next = new Node(4);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.prev = head.next.next.next;
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.prev = head.next.next.next.next;
		head.next.next.child = new Node(7);
		head.next.next.child.next = new Node(8);
		head.next.next.child.next.prev = head.next.next.child.next;
		head.next.next.child.next.next = new Node(9);
		head.next.next.child.next.next.prev = head.next.next.child.next.next;
		head.next.next.child.next.next.next = new Node(10);
		head.next.next.child.next.next.next.prev = head.next.next.child.next.next.next;
		head.next.next.child.next.child = new Node(11);
		head.next.next.child.next.child.next = new Node(12);
		head.next.next.child.next.child.next.prev = head.next.next.child.next.child;
		
		Node result = flatten(head);
	}
	
	public static Node flatten(Node head) {
		if (head == null) {
			return null;
		}
		
		Node result = recurrentFlatten(head, null);
		
		return result;
	}
	
	public static Node recurrentFlatten(Node head, Node tail) {
		if (head == null) {
			return tail;
		}
		
		head.next = recurrentFlatten(head.child, recurrentFlatten(head.next, tail));
		
		if (head.next != null) {
			head.next.prev = head;
		}
		
		head.child = null;
		
		return head;
	}
}