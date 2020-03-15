/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 *  Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumEvenGrandparent = function(root) {
	let sum = 0;
	
	const dfs = (node) => {
		if (!node) {
			return;
		}
		
		if (node.val % 2 == 0) {
			getGrandchild(node.left);
			getGrandchild(node.right);
		}
		
		dfs(node.left);
		dfs(node.right);
	};
	
	const getGrandchild = (parent) => {
		if (!parent) {
			return;
		}
		
		if (parent.left) {
			sum += parent.left.val;
		}
		
		if (parent.right) {
			sum += parent.right.val;
		}
	}
	
	dfs(root);
	
	return sum;
};

function TreeNode(val) {
	this.val = val;
	this.left = this.right = null;
}

/*let root = new TreeNode(6);

root.left = new TreeNode(7);
root.right = new TreeNode(8);
root.left.left = new TreeNode(2);
root.left.right = new TreeNode(7);
root.left.left.left = new TreeNode(9);
root.left.right.left = new TreeNode(1);
root.left.right.right = new TreeNode(4);
root.right.left = new TreeNode(1);
root.right.right = new TreeNode(3);
root.right.right.right = new TreeNode(5);*/

let root = new TreeNode(61);

root.left = new TreeNode(13);
root.right = new TreeNode(46);
root.right.right = new TreeNode(56);
root.right.right.left = new TreeNode(72);

console.log(sumEvenGrandparent(root));