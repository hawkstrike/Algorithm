/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree = function(root) {
	let diameter = 0;
	
	/**
	 * @param {TreeNode} root
	 * @returns {number}
	 */
	const recurrentDiameterOfBinaryTree = (root) => {
		if (root === null) {
			return 0;
		}
		
		const left = recurrentDiameterOfBinaryTree(root.left);
		const right = recurrentDiameterOfBinaryTree(root.right);
		
		diameter = Math.max(diameter, left + right);
		
		return 1 + Math.max(left, right);
	};
	
	recurrentDiameterOfBinaryTree(root);
	
	return diameter;
};

function TreeNode(val, left, right) {
	this.val = (val === undefined) ? 0 : val;
	this.left = (left === undefined) ? null : left;
	this.right = (right === undefined) ? null : right;
}

const root = new TreeNode(1, null, null);

root.left = new TreeNode(2, null, null);
root.right = new TreeNode(3, null, null);
root.left.left = new TreeNode(4, null, null);
root.left.right = new TreeNode(5, null, null);

console.log(diameterOfBinaryTree(root));