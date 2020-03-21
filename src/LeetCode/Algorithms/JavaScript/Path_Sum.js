/**
 * https://leetcode.com/problems/path-sum/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {boolean}
 */
var hasPathSum = function(root, sum) {
	let result = false;
	
	const recurrentHasPathSum = (root, pathSum = 0) => {
		if (!root) {
			return;
		} else {
			pathSum += root.val;
		}
		
		if (pathSum === sum && root.left == null && root.right == null) {
			result = true;
			
			return;
		}
		
		recurrentHasPathSum(root.left, pathSum);
		recurrentHasPathSum(root.right, pathSum);
	};
	
	recurrentHasPathSum(root, 0);
	
	return result;
};

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

const sum = 22;
let root = new TreeNode(5);

root.left = new TreeNode(4);
root.right = new TreeNode(8);
root.left.left = new TreeNode(11);
root.left.left.left = new TreeNode(7);
root.left.left.right = new TreeNode(2);
root.right.left = new TreeNode(13);
root.right.right = new TreeNode(4);
root.right.right.right = new TreeNode(1);

console.log(hasPathSum(root, sum));