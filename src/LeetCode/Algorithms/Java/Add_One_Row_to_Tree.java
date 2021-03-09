package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/add-one-row-to-tree/
public class Add_One_Row_to_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		int v = 1;
		int d = 2;
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		
		TreeNode result = addOneRow(root, v, d);
		
		printTreeNode(result);
	}
	
	public static TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode treeNode = new TreeNode(v);
			
			treeNode.left = root;
			
			return treeNode;
		}
		
		recurrentAddOneRow(root, v, d, 1);
		
		return root;
	}
	
	public static void recurrentAddOneRow(TreeNode curr, int v, int d, int depth) {
		if (curr == null) {
			return;
		}
		
		if (d - 1 == depth) {
			TreeNode treeNode = curr.left;
			
			curr.left = new TreeNode(v);
			curr.left.left = treeNode;
			
			treeNode = curr.right;
			curr.right = new TreeNode(v);
			curr.right.right = treeNode;
		} else {
			recurrentAddOneRow(curr.left, v, d, depth + 1);
			recurrentAddOneRow(curr.right, v, d, depth + 1);
		}
	}
	
	public static void printTreeNode(TreeNode curr) {
		if (curr == null) {
			return;
		}
		
		printTreeNode(curr.left);
		System.out.println(curr.val);
		printTreeNode(curr.right);
	}
}