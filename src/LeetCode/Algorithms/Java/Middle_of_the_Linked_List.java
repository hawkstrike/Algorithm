package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/middle-of-the-linked-list/
public class Middle_of_the_Linked_List {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		//head.next.next.next.next.next = new ListNode(6);
		
		ListNode result = middleNode(head);
		
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
		
		/*ListNode node = head;
		int length = 0;
		int middle = 0;
		
		while (node != null) {
			length++;
			node = node.next;
		}
		
		middle = length / 2;
		node = head;
		
		for (int i = 0; i < middle; i++) {
			node = node.next;
		}
		
		return node;*/
	}
}