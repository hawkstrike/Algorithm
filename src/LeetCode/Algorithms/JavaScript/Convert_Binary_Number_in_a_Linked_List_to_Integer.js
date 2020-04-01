/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {number}
 */
var getDecimalValue = function(head) {
	let result = 0;
	let curr = head;
	
	while (curr) {
		result = result << 1 | curr.val;
		curr = curr.next;
	}
	
	return result;
};

function ListNode(val) {
	this.val = val;
	this.next = null;
}

let head = new ListNode(1);

head.next = new ListNode(0);
head.next.next = new ListNode(1);

console.log(getDecimalValue(head));