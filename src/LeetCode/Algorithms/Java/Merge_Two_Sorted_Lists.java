package LeetCode.Algorithms.Java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class Merge_Two_Sorted_Lists {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);*/
		/*ListNode l1 = null;
		ListNode l2 = null;*/
		ListNode l1 = null;
		ListNode l2 = new ListNode(0);
		
		ListNode result = mergeTwoLists(l1, l2);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		List<Integer> list = new LinkedList<>();
		
		while (l1 != null) {
			list.add(l1.val);
			l1 = l1.next;
		}
		
		while (l2 != null) {
			list.add(l2.val);
			l2 = l2.next;
		}
		
		Collections.sort(list);
		
		ListNode result = new ListNode(-1);
		ListNode curr = result;
		
		for (int n : list) {
			curr.next = new ListNode(n);
			curr = curr.next;
		}
		
		return result.next;
		
		/*ListNode curr = new ListNode(-1);
		ListNode result = curr;
		
		for (int n : list) {
			curr.next = new ListNode(n);
			curr = curr.next;
		}
		
		return result.next;*/
	}
}