package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/remove-linked-list-elements/
public class Remove_Linked_List_Elements {
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		
		int val = 6;
		
		ListNode result = removeElements(head, val);
	}
	
	public static ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		
		head.next = removeElements(head.next, val);
		
		return (head.val == val) ? head.next : head;
	}
}