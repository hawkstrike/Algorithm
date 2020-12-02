package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/linked-list-random-node/
public class Linked_List_Random_Node {
	public static class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	public static class Solution {
		private List<Integer> list = new LinkedList<>();
		
		/** @param head The linked list's head.
		Note that the head is guaranteed to be not null, so it contains at least one node. */
		public Solution(ListNode head) {
			while (head != null) {
				this.list.add(head.val);
				
				head = head.next;
			}
		}
		
		/** Returns a random node's value. */
		public int getRandom() {
			int index = (int) (Math.random() * this.list.size());
			
			return this.list.get(index);
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		
		Solution solution = new Solution(head);
		
		System.out.println(solution.getRandom());
	}
}