/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
	let result = new Array();
	let queue = [];
	
	if (root != null) {
		queue.unshift(root);
		
		while (queue.length > 0) {
			let levelArr = new Array();
			let length = queue.length;
			
			for (let i = 0; i < length; i++) {
				let curr = queue.pop();
				
				if (curr.left) {
					queue.unshift(curr.left);
				}
				
				if (curr.right) {
					queue.unshift(curr.right);
				}
				
				levelArr.push(curr.val);
			}
			
			result.push(levelArr);
		}
	}
	
	return result;
};

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

let root = new TreeNode(3);

root.left = new TreeNode(9);
root.right = new TreeNode(20);
root.right.left = new TreeNode(15);
root.right.right = new TreeNode(7);

console.log(levelOrder(root));