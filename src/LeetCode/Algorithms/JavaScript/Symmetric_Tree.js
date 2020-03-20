/**
 * https://leetcode.com/problems/symmetric-tree/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
	let queue = [];
	
	if (root) {
		queue.unshift(root.left);
		queue.unshift(root.right);
		
		while (queue.length > 0) {
			let curr1 = queue.pop();
			let curr2 = queue.pop();
			
			if (!curr1 && !curr2) {
				continue;
			}
			
			if ((!curr1 || !curr2) || (curr1.val !== curr2.val)) {
				return false;
			}
			
			queue.unshift(curr1.left);
			queue.unshift(curr2.right);
			queue.unshift(curr1.right);
			queue.unshift(curr2.left);
		}
	}
	
	return true;
};

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

let root = new TreeNode(1);

/*root.left = new TreeNode(2);
root.right = new TreeNode(2);
root.left.left = new TreeNode(3);
root.left.right = new TreeNode(4);
root.right.left = new TreeNode(4);
root.right.right = new TreeNode(3);*/

root.left = new TreeNode(2);
root.right = new TreeNode(2);
root.left.right = new TreeNode(3);
root.right.right = new TreeNode(3);

console.log(isSymmetric(root));