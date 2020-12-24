package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/swap-nodes-in-pairs/
public class Swap_Nodes_in_Pairs {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		//ListNode head = new ListNode(1);
		
		ListNode result = swapPairs(head);
		
		while (result != null) {
			System.out.print(result.val + " ");
			
			result = result.next;
		}
		System.out.println();
	}
	
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode curr = head.next;
		head.next = swapPairs(head.next.next);
		curr.next = head;
		
		return curr;
	}
}