package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/linked-list-cycle/
public class Linked_List_Cycle {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		
		System.out.println(hasCycle(head));
	}
	
	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		
		ListNode slow = head;
		
		head = head.next;
		
		while (head != null && head.next != null) {
			if (slow == head) {
				return true;
			}
			
			slow = slow.next;
			head = head.next.next;
		}
		
		return false;
	}
}