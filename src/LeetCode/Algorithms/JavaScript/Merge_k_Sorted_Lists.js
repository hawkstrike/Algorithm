/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
/**
 * @param {ListNode} left
 * @param {ListNode} right
 * @returns {*}
 */
var mergeKLists = function(lists) {
	/**
	 * @param {ListNode} left
	 * @param {ListNode} right
	 * @returns {*}
	 */
	const merge = (left, right) => {
		if (!left) {
			return right;
		} else if (!right) {
			return left;
		} else if (left.val < right.val) {
			left.next = merge(left.next, right);
			
			return left;
		} else {
			right.next = merge(left, right.next);
			
			return right;
		}
	};
	
	/**
	 * @param {ListNode[]} lists
	 * @param {number} start
	 * @param {number} end
	 */
	const divide = (lists, start, end) => {
		if (start === end) {
			return lists[start];
		} else if (start < end) {
			let mid = parseInt((start + end) / 2);
			let left = divide(lists, start, mid);
			let right = divide(lists, mid + 1, end);
			
			return merge(left, right);
		} else {
			return null;
		}
	};
	
	return divide(lists, 0, lists.length - 1);
};
/*var mergeKLists = function(lists) {
	const head = new ListNode(null);
	let curr = head;
	const q = new PriorityQueue();
	
	for (const list of lists) {
		if (list) {
			q.push(list, list.val);
		}
	}
	
	while (!q.isEmpty()) {
		const e = q.pop();
		
		if (e) {
			const ln = e.element;
			
			curr.next = ln;
			curr = curr.next;
			
			const next = ln.next;
			
			if (next) {
				q.push(next, next.val);
			}
		}
	}
	
	return head.next;
};

class Element {
	/!**
	 * @param {ListNode} element
	 * @param {number} val
	 *!/
	constructor(element, val) {
		this.element = element;
		this.val = val;
	}
}

class PriorityQueue {
	constructor() {
		this.items = [];
	}
	
	/!**
	 * @param {ListNode} element
	 * @param {number} val
	 *!/
	push(element, val) {
		let queue = new Element(element, val);
		const index = this.getIndex(this.items, queue, 0, this.items.length - 1);
		
		if (index >= 0) {
			this.items.splice(index, 0, queue);
		} else {
			this.items.push(queue);
		}
	}
	
	pop() {
		if (this.isEmpty()) {
			return null;
		}
		
		return this.items.shift();
	}
	
	isEmpty() {
		return this.items.length == 0;
	}
	
	/!**
	 * @param {Array} arr
	 * @param {Element} x
	 * @param {number} start
	 * @param {number} end
	 * @returns {number}
	 *!/
	getIndex(arr, x, start, end) {
		if (start > end) {
			return -1;
		}
		
		let mid = Math.floor((start + end) / 2);
		
		if (arr[mid].val > x.val) {
			if (!arr[mid - 1] || arr[mid - 1].val <= x.val) {
				return mid;
			}
			
			return this.getIndex(arr, x, start, mid - 1);
		} else {
			return this.getIndex(arr, x, mid + 1, end);
		}
	}
}*/

function ListNode(val) {
	this.val = val;
	this.next = null;
}

let lists = new Array();
let ln1 = new ListNode(1);
let ln2 = new ListNode(1);
let ln3 = new ListNode(2);

ln1.next = new ListNode(4);
ln1.next.next = new ListNode(5);
ln2.next = new ListNode(3);
ln2.next.next = new ListNode(4);
ln3.next = new ListNode(6);

lists.push(ln1, ln2, ln3);

console.log(mergeKLists(lists));
