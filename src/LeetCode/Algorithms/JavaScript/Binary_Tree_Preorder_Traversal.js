/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
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
var preorderTraversal = function(root) {
	let result = [];
	
	if (root != null) {
		result.push(root.val);
		result.push(...preorderTraversal(root.left));
		result.push(...preorderTraversal(root.right));
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

console.log(preorderTraversal(root));