/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root) {
	let result = [];
	
	if (root != null) {
		result.push(...postorderTraversal(root.left));
		result.push(...postorderTraversal(root.right));
		result.push(root.val);
	}
	
	return result;
	
	/*let result = [];
	let stack = [root];
	
	if (root != null) {
		while (stack.length) {
			const curr = stack.pop();
			
			if (curr) {
				result.push(curr.val);
				
				stack.push(curr.right);
				stack.push(curr.left);
			}
		}
	}
	
	return result;*/
};

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

let root = new TreeNode(1);

root.right = new TreeNode(2);
root.right.left = new TreeNode(3);

console.log(postorderTraversal(root));