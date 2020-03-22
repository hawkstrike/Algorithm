/**
 * https://leetcode.com/problems/path-sum-ii/
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number[][]}
 */
var pathSum = function(root, sum) {
	let result = [];
	
	const recurrentPathSum = (root, list = [], curr = 0) => {
		if (!root) {
			return;
		}
		
		let tempList = [...list];
		
		curr += root.val;
		tempList.push(root.val);
		
		if (curr === sum && root.left == null && root.right == null) {
			result.push(tempList);
			
			return;
		}
		
		recurrentPathSum(root.left, tempList, curr);
		recurrentPathSum(root.right, tempList, curr);
	};
	
	recurrentPathSum(root);
	
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
root.right.right.left = new TreeNode(5);
root.right.right.right = new TreeNode(1);

console.log(pathSum(root, sum));