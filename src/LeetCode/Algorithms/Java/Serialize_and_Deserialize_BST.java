package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/serialize-and-deserialize-bst/
public class Serialize_and_Deserialize_BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static class Codec {
		
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null) {
				return null;
			}
			
			StringBuffer sb = new StringBuffer();
			
			recurrentSerialize(root, sb);
			
			sb.deleteCharAt(sb.length() - 1);
			
			return sb.toString();
		}
		
		private void recurrentSerialize(TreeNode root, StringBuffer sb) {
			if (root == null) {
				return;
			}
			
			sb.append(root.val).append(" ");
			
			recurrentSerialize(root.left, sb);
			recurrentSerialize(root.right, sb);
		}
		
		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data == null || "".equals(data)) {
				return null;
			}
			
			String[] arr = data.split("\\s");
			TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
			
			for (int i = 1; i < arr.length; i++) {
				TreeNode curr = root;
				int val = Integer.parseInt(arr[i]);
				
				while (true) {
					if (curr.val > val) {
						if (curr.left != null) {
							curr = curr.left;
						} else {
							curr.left = new TreeNode(val);
							break;
						}
					} else {
						if (curr.right != null) {
							curr = curr.right;
						} else {
							curr.right = new TreeNode(val);
							break;
						}
					}
				}
			}
			
			return root;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		Codec ser = new Codec();
		Codec deser = new Codec();
		String tree = ser.serialize(root);
		TreeNode curr = deser.deserialize(tree);
		
		System.out.println("tree : " + tree);
		printTree(curr);
	}
	
	public static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		
		System.out.println(root.val);
		printTree(root.left);
		printTree(root.right);
	}
}