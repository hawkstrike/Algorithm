package LeetCode.Algorithms.Java;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class Merge_k_Sorted_Lists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode[] lists = new ListNode[3];
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(1);
		ListNode ln3 = new ListNode(2);
		
		ln1.next = new ListNode(4);
		ln1.next.next = new ListNode(5);
		ln2.next = new ListNode(3);
		ln2.next.next = new ListNode(4);
		ln3.next = new ListNode(6);
		
		lists[0] = ln1;
		lists[1] = ln2;
		lists[2] = ln3;
		
		//System.out.println(mergeKLists(lists));
		ListNode result = mergeKLists(lists);
		
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println();
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode result = new ListNode(0);
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		for (ListNode ln : lists) {
			while (ln != null) {
				pq.add(ln.val);
				ln = ln.next;
			}
		}
		
		ListNode point = result;
		while (!pq.isEmpty()) {
			ListNode curr = new ListNode(pq.poll());
			point.next = curr;
			point = point.next;
		}
		
		return result.next;
	}
}