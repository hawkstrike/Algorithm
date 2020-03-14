/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 *  Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/*let currDepth = 0;
let totalSum = 0;*/

/**
 * @param {TreeNode} root
 * @param {Array} arr
 * @param {Number} depth
 * @return {number}
 */
var deepestLeavesSum = function(root, arr = [], depth = 0) {
	if (!root) {
		return;
	}
	
	arr[depth] = (arr[depth] || 0) + root.val;
	deepestLeavesSum(root.left, arr, depth + 1);
	deepestLeavesSum(root.right, arr, depth + 1);
	
	return arr[arr.length - 1];
};

/**
 * @param {TreeNode} root
 * @param {number} depth
 */
/*let findDeepestLeaves = function (root, depth) {
	if (root != null && depth > currDepth) {
		currDepth = depth;
		totalSum = root.val;
	} else if (depth == currDepth) {
		totalSum += root.val;
	}
	
	if (root.left) {
		findDeepestLeaves(root.left, depth + 1);
	}
	
	if (root.right) {
		findDeepestLeaves(root.right, depth + 1);
	}
};*/

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

let root = new TreeNode(1);

root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);
root.left.left.left = new TreeNode(7);
root.right.right = new TreeNode(6);
root.right.right.right = new TreeNode(8);

console.log(deepestLeavesSum(root));