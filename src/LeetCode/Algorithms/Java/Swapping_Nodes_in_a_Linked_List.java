package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/add-digits/
public class Swapping_Nodes_in_a_Linked_List {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*ListNode head = new ListNode(1);
		int k = 2;
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);*/
		ListNode head = new ListNode(7);
		int k = 5;
		
		head.next = new ListNode(9);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next = new ListNode(0);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next.next.next.next.next = new ListNode(5);
		
		ListNode result = swapNodes(head, k);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		
		System.out.println();
	}
	
	public static ListNode swapNodes(ListNode head, int k) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode begin = head;
		ListNode end = head;
		
		for (int i = 0; i < k - 1; i++) {
			fast = fast.next;
		}
		
		begin = fast;
		
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		end = slow;
		
		int temp = begin.val;
		begin.val = end.val;
		end.val = temp;
		
		return head;
	}
}