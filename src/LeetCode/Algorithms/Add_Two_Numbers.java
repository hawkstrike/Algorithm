package LeetCode.Algorithms;

// https://leetcode.com/problems/add-two-numbers/
public class Add_Two_Numbers {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode ln11 = new ListNode(1);
		ListNode ln12 = new ListNode(8);
		//ListNode ln13 = new ListNode(-9);
		ListNode ln21 = new ListNode(0);
		//ListNode ln22 = new ListNode(-2);
		//ListNode ln23 = new ListNode(-2);

		ln11.next = ln12;
		//ln12.next = ln13;

		//ln21.next = ln22;
		//ln22.next = ln23;

		ListNode result = addTwoNumbers(ln11, ln21);
		System.out.println();
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		int up = 0;

		do {
			int value1 = l1 != null ? l1.val : 0;
			int value2 = l2 != null ? l2.val : 0;
			int sum = up + value1 + value2;

			up = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;

			if(l1 != null)
				l1 = l1.next;

			if(l2 != null)
				l2 = l2.next;

		} while(l1 != null || l2 != null);

		if(up != 0) {
			curr.next = new ListNode(up);
		}

		return head.next;
	}
}