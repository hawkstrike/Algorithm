package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/rotate-list/
public class Rotate_List {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		int k = 2;
		ListNode head = new ListNode(1);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		/*int k = 4;
		ListNode head = new ListNode(0);
		
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);*/
		
		ListNode result = rotateRight(head, k);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
	
	public static ListNode rotateRight(ListNode head, int k) {
		ListNode slow = head;
		ListNode fast = head;
		
		if (head == null) {
			return null;
		}
		
		ListNode curr = head;
		int count = 0;
		
		while (curr != null) {
			curr = curr.next;
			count++;
		}
		
		k %= count;
		
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		fast.next = head;
		
		ListNode result = slow.next;
		
		slow.next = null;
		
		return result;
		
		
		/*if (head == null || head.next == null || k == 0) {
			return head;
		}
		
		int length = 1;
		ListNode curr = head;
		
		while (curr.next != null) {
			curr = curr.next;
			length++;
		}
		
		curr.next = head;
		
		k %= length;
		k = length - k;
		
		curr = head;
		
		for (int i = 0; i < k - 1; i++) {
			curr = curr.next;
		}
		
		head = curr.next;
		curr.next = null;
		
		return head;*/
		
		/*ListNode result = head;
		
		for (int i = 0; i < k; i++) {
			result = recurrentRotateRight(result);
		}
		
		return result;*/
	}
	
	/*public static ListNode recurrentRotateRight(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode root = head;
		int firstValue = -1;
		
		while (root != null) {
			firstValue = root.val;
			root = root.next;
		}
		
		ListNode node = new ListNode(firstValue);
		ListNode result = node;
		
		while (head != null) {
			if (firstValue != head.val) {
				node.next = new ListNode(head.val);
				node = node.next;
			}
			
			head = head.next;
		}
		
		return result;
	}*/
}