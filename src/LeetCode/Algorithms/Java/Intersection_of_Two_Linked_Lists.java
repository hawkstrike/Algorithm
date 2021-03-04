package LeetCode.Algorithms.Java;

// hhttps://leetcode.com/problems/intersection-of-two-linked-lists/
public class Intersection_of_Two_Linked_Lists {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int x) {
			this.val = x;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		ListNode headA = new ListNode(4);
		ListNode headB = new ListNode(5);
		
		headA.next = new ListNode(1);
		headA.next.next = new ListNode(8);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);
		headB.next = new ListNode(6);
		headB.next.next = new ListNode(1);
		headB.next.next.next = new ListNode(8);
		headB.next.next.next.next = new ListNode(4);
		headB.next.next.next.next.next = new ListNode(5);
		
		ListNode result = getIntersectionNode(headA, headB);
		
		while (result != null) {
			System.out.println(result.val);
			
			result = result.next;
		}
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode list1 = headA;
		ListNode list2 = headB;
		
		while (list1 != list2) {
			list1 = (list1 == null) ? headB : list1.next;
			list2 = (list2 == null) ? headA : list2.next;
		}
		
		return list1;
	}
}