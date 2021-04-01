package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/palindrome-linked-list/
public class Palindrome_Linked_List {
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
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);*/
		ListNode head = new ListNode(1);
		
		head.next = new ListNode(2);
		
		System.out.println(isPalindrome(head));
	}
	
	public static boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast != null) {
			slow = slow.next;
		}
		
		slow = reverseListNode(slow);
		fast = head;
		
		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			
			fast = fast.next;
			slow = slow.next;
		}
		
		return true;
	}
	
	public static ListNode reverseListNode(ListNode head) {
		ListNode prev = null;
		
		while (head != null) {
			ListNode next = head.next;
			
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return prev;
	}
}