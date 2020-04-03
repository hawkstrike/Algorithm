/**
 * https://leetcode.com/problems/invert-binary-tree/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function(root) {
	if (!root) {
		return null;
	}
	
	let currLeft = invertTree(root.left);
	let currRight = invertTree(root.right);
	
	root.right = currLeft;
	root.left = currRight;
	
	return root;
};

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

let root = new TreeNode(4);

root.left = new TreeNode(2);
root.right = new TreeNode(7);
root.left.left = new TreeNode(1);
root.left.right = new TreeNode(3);
root.right.left = new TreeNode(6);
root.right.right = new TreeNode(9);

console.log(invertTree(root));