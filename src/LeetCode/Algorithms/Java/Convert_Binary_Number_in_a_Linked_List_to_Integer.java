package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class Convert_Binary_Number_in_a_Linked_List_to_Integer {
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			this.val = x;
		}
	}
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		
		System.out.println(getDecimalValue(head));
	}
	
	public static int getDecimalValue(ListNode head) {
		int result = 0;
		int length = -1;
		ListNode curr = head;
		
		while (head != null) {
			head = head.next;
			length++;
		}
		
		while (curr != null) {
			result += curr.val << length;
			length--;
			
			curr = curr.next;
		}
		
		return result;
	}
}