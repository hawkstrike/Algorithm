package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/odd-even-linked-list/
public class Odd_Even_Linked_List {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	public static void main(String[] args) {
		/*ListNode root = new ListNode(1);
		
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);*/
		ListNode root = new ListNode(2);

		root.next = new ListNode(1);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(5);
		root.next.next.next.next = new ListNode(6);
		root.next.next.next.next.next = new ListNode(4);
		root.next.next.next.next.next.next = new ListNode(7);
		//ListNode root = null;
		
		ListNode result = oddEvenList(root);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		System.out.println();
	}
	
	public static ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode oddNode = head;
		ListNode evenNode = head.next;
		ListNode evenHead = evenNode;
		
		while (evenNode != null && evenNode.next != null) {
			oddNode.next = evenNode.next;
			oddNode = oddNode.next;
			evenNode.next = oddNode.next;
			evenNode = evenNode.next;
		}
		
		oddNode.next = evenHead;
		
		return head;
		
		/*ListNode result = new ListNode(0);
		ListNode oddNode = new ListNode(0);
		ListNode evenNode = new ListNode(0);
		ListNode currOdd = new ListNode(0);
		ListNode currEven = new ListNode(0);
		
		oddNode = currOdd;
		evenNode = currEven;
		
		while (head != null) {
			currOdd.next = new ListNode(head.val);
			currOdd = currOdd.next;
			head = head.next;
			
			if (head != null) {
				currEven.next = new ListNode(head.val);
				currEven = currEven.next;
				head = head.next;
			}
		}
		
		result.next = oddNode;
		
		if (result.next.next != null) {
			ListNode curr = result.next.next;
			
			while (curr.next != null) {
				curr = curr.next;
			}
			
			curr.next = evenNode.next;
		}
		
		return result.next.next;*/
	}
}