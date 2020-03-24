/**
 * https://leetcode.com/problems/path-sum-iii/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number}
 */
var pathSum = function(root, sum) {
	if (!root) {
		return 0;
	}
	
	const recurrentPathSum = (root, sum) => {
		if (!root) {
			return 0;
		}
		
		return ((root.val === sum) ? 1 : 0) + recurrentPathSum(root.left, sum - root.val) + recurrentPathSum(root.right, sum - root.val);
	};
	
	return recurrentPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
};

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

const sum = 8;
let root = new TreeNode(10);

root.left = new TreeNode(5);
root.right = new TreeNode(-3);
root.left.left = new TreeNode(3);
root.left.right = new TreeNode(2);
root.left.left.left = new TreeNode(3);
root.left.left.right = new TreeNode(-2);
root.left.right = new TreeNode(2);
root.left.right.right = new TreeNode(1);
root.right.right = new TreeNode(11);

console.log(pathSum(root, sum));