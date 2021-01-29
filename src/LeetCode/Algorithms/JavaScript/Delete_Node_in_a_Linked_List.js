/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @param {ListNode} node
 * @return {void} Do not return anything, modify node in-place instead.
 */
var deleteNode = function(node) {
	node.val = node.next.val;
	node.next = node.next.next;
};

function ListNode(val) {
	this.val = val;
	this.next = null;
}

const node = new ListNode(5);

console.log(deleteNode(node));