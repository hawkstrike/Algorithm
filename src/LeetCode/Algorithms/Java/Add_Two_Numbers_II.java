package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/add-two-numbers-ii/
public class Add_Two_Numbers_II {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		ListNode l2 = new ListNode(5);
		
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = addTwoNumbers(l1, l2);
		
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode l3 = head;
		int carry = 0;
		
		l1 = reverseListNode(l1);
		l2 = reverseListNode(l2);
		
		while ((l1 != null || l2 != null || carry != 0)) {
			int num1 = (l1 == null) ? 0 : l1.val;
			int num2 = (l2 == null) ? 0 : l2.val;
			int sum = num1 + num2 + carry;
			
			l3.next = new ListNode(sum % 10);
			carry = sum / 10;
			
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			l3 = l3.next;
		}
		
		return reverseListNode(head.next);
	}
	
	public static ListNode reverseListNode(ListNode head) {
		ListNode root = null;
		ListNode next;
		
		while (head != null) {
			next = head.next;
			head.next = root;
			root = head;
			head = next;
		}
		
		return root;
	}
}