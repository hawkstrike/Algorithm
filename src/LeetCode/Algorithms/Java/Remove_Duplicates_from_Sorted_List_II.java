package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class Remove_Duplicates_from_Sorted_List_II {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*ListNode head = new ListNode(1);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);*/
		ListNode head = new ListNode(1);
		
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		
		ListNode result = deleteDuplicates(head);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		
		System.out.println();
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode result = new ListNode(-1);
		ListNode curr = result;
		
		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				
				head = head.next;
			} else {
				curr.next = new ListNode(head.val);
				curr = curr.next;
				head = head.next;
			}
		}
		
		return result.next;
	}
}