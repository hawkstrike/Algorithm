package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree
public class Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {}
		
		TreeNode(int val) {
			this.val = val;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(0);
		
		root.left = new TreeNode(1);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.left.left.right = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(0);
		root.left.right.right = new TreeNode(0);
		root.right.left = new TreeNode(0);
		
		int[] arr = {0, 1, 0, 1};*/
		TreeNode root = new TreeNode(4);
		
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(4);
		root.right.right.left = new TreeNode(4);
		
		int[] arr = {4, 2, 7, 4};
		
		System.out.println(isValidSequence(root, arr));
	}
	
	public static boolean isValidSequence(TreeNode root, int[] arr) {
		return recurrentIsValidSequece(root, arr, 0);
	}
	
	public static boolean recurrentIsValidSequece(TreeNode root, int[] arr, int depth) {
		if (root == null || depth >= arr.length) {
			return false;
		}
		
		if (root.left == null && root.right == null) {
			return (depth == arr.length - 1) && (root.val == arr[depth]);
		}
		
		if (root.val == arr[depth]) {
			return recurrentIsValidSequece(root.left, arr, depth + 1) || recurrentIsValidSequece(root.right, arr, depth + 1);
		}
		
		return false;
	}
}