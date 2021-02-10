package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/copy-list-with-random-pointer/
public class Copy_List_with_Random_Pointer {
	public static class Node {
		int val;
		Node next;
		Node random;
		
		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(7);
		
		head.next = new Node(13);
		head.random = new Node(0);
		head.next.next = new Node(11);
		head.next.random = new Node(4);
		head.next.next.next = new Node(10);
		head.next.next.random = new Node(2);
		head.next.next.next.next = new Node(1);
		head.next.next.next.random = new Node(0);
		
		Node result = copyRandomList(head);
		
		while (result != null) {
			System.out.print(result.val + " ");
			
			if (result.random != null) {
				System.out.print(result.random.val);
			}
			System.out.println();
			
			result = result.next;
		}
	}
	
	public static Node copyRandomList(Node head) {
		HashMap<Node, Node> hashMap = new HashMap<>();
		Node curr = head;
		
		while (curr != null) {
			hashMap.put(curr, new Node(curr.val));
			curr = curr.next;
		}
		
		curr = head;
		
		while (curr != null) {
			hashMap.get(curr).next = hashMap.get(curr.next);
			hashMap.get(curr).random = hashMap.get(curr.random);
			curr = curr.next;
		}
		
		return hashMap.get(head);
	}
}