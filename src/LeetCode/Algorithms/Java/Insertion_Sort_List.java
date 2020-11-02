package LeetCode.Algorithms.Java;

import java.util.Collections;
import java.util.LinkedList;

// https://leetcode.com/problems/insertion-sort-list/
public class Insertion_Sort_List {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		/*ListNode head = new ListNode(4);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);*/
		ListNode head = new ListNode(-1);
		
		head.next = new ListNode(5);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(0);
		
		ListNode result = insertionSortList(head);
		
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
		LinkedList<Integer> list = new LinkedList<>();
		
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		
		Collections.sort(list);
		
		ListNode root = new ListNode(Integer.MIN_VALUE);
		ListNode curr = root;
		
		for (int n : list) {
			curr.next = new ListNode(n);
			curr = curr.next;
		}
		
		return root.next;
	}
}