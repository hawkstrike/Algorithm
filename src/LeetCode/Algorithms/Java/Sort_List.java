package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/sort-list/
public class Sort_List {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	// [-1,5,3,4,0]
	public static void main(String[] args) {
		ListNode head = new ListNode(-1);
		
		head.next = new ListNode(5);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(0);
		/*ListNode head = new ListNode(4);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);*/
		
		ListNode result = sortList(head);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
	}
	
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast = slow.next;
		slow.next = null;
		
		return mergeListNode(sortList(head), sortList(fast));
	}
	
	public static ListNode mergeListNode(ListNode left, ListNode right) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		
		while (left != null && right != null) {
			if (left.val <= right.val) {
				curr.next = left;
				left = left.next;
			} else {
				curr.next = right;
				right = right.next;
			}
			
			curr = curr.next;
		}
		
		if (left != null) {
			curr.next = left;
		} else if (right != null) {
			curr.next = right;
		}
		
		return head.next;
	}
}