/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * https://leetcode.com/problems/add-two-numbers/
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
	let head = new ListNode(0);
	let curr = head;
	let up = 0;
	
	while (l1 !== null || l2 !== null) {
		let value1 = l1 != null ? l1.val : 0;
		let value2 = l2 != null ? l2.val : 0;
		let sum = up + value1 + value2;
		
		up = Math.floor(sum / 10);
		curr.next = new ListNode(parseInt(sum % 10));
		curr = curr.next;
		
		if (l1 !== null) {
			l1 = l1.next;
		}
		
		if (l2 !== null) {
			l2 = l2.next;
		}
	}
	
	if (up !== 0) {
		curr.next = new ListNode(up);
	}
	
	return head.next;
};

function ListNode(val) {
	this.val = val;
	this.next = null;
}

let l1 = new ListNode(2);
let l2 = new ListNode(5);

l1.next = new ListNode(4);
l1.next.next = new ListNode(3);
l2.next = new ListNode(6);
l2.next.next = new ListNode(4);

console.log(addTwoNumbers(l1, l2));