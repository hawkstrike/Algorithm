/**
 * https://leetcode.com/problems/range-sum-of-bst/
 *  Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} L
 * @param {number} R
 * @return {number}
 */
var rangeSumBST = function(root, L, R) {
	let result = 0;
	
	const recurrentRangeSumBST = (root) => {
		if (!root) {
			return;
		}
		
		if (root.val >= L && root.val <= R) {
			result += root.val;
		}
		
		if (root.left) {
			recurrentRangeSumBST(root.left);
		}
		
		if (root.right) {
			recurrentRangeSumBST(root.right);
		}
	};
	
	recurrentRangeSumBST(root);
	
	return result;
};



function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

//const L = 7, R = 15;
const L = 6, R = 10;
let root = new TreeNode(10);

root.left = new TreeNode(5);
root.right = new TreeNode(15);
root.left.left = new TreeNode(3);
root.left.right = new TreeNode(7);
root.right.left = new TreeNode(13);
root.right.right = new TreeNode(18);
root.left.left.left = new TreeNode(1);
root.left.right.left = new TreeNode(6);

/*root.left = new TreeNode(5);
root.right = new TreeNode(15);
root.left.left = new TreeNode(3);
root.left.right = new TreeNode(7);
root.right.right = new TreeNode(18);*/


console.log(rangeSumBST(root, L, R));