package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class Linked_List_Cycle_II {
	static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		int pos = 1;
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(0);
		head.next.next.next.next = new ListNode(-4);
		
		int index = 0;
		
		while (head != null && index == pos) {
			head = head.next;
			index++;
		}
		
		ListNode result = detectCycle(head);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
	}
	
	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) {
				slow = head;
				break;
			}
		}
		
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return slow;
			}
			
			slow = slow.next;
			fast = fast.next;
		}
		
		return null;
	}
}