/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
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
var averageOfLevels = function(root) {
	let treeNodeArr = new Array();
	
	const recurrentAverageOfLevels = (root, depth) => {
		if (!root) {
			return;
		} else if (!treeNodeArr[depth]) {
			treeNodeArr[depth] = new Array();
		}
		
		treeNodeArr[depth].push(root.val);
		
		recurrentAverageOfLevels(root.left, depth + 1);
		recurrentAverageOfLevels(root.right, depth + 1);
	};
	
	recurrentAverageOfLevels(root, 0);
	
	return treeNodeArr.map(arr => arr.reduce((a, b) => a + b, 0) / arr.length);
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

/*let root = new TreeNode(3);

root.left = new TreeNode(1);
root.right = new TreeNode(5);
root.left.left = new TreeNode(0);
root.left.right = new TreeNode(2);
root.right.left = new TreeNode(4);
root.right.right = new TreeNode(6);*/

console.log(averageOfLevels(root));