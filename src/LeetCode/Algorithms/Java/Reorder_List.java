package LeetCode.Algorithms.Java;

import java.util.ArrayList;

// https://leetcode.com/problems/reorder-list/
public class Reorder_List {
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		reorderList(head);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		
		ArrayList<ListNode> list = new ArrayList<>();
		ListNode curr = head;
		
		while (curr != null) {
			list.add(curr);
			curr = curr.next;
		}
		
		int i = 1;
		int left = 1;
		int right = list.size() - 1;
		
		curr = head;
		
		while (i < list.size()) {
			if (i % 2 == 0) {
				curr.next = list.get(left++);
			} else {
				curr.next = list.get(right--);
			}
			
			curr = curr.next;
			i++;
		}
		
		curr.next = null;
	}
}