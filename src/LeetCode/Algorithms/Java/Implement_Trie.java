package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Implement_Trie {
	public static class TrieNode {
		private TrieNode[] links;
		private final int R = 26;
		private boolean isEnd;
		
		public TrieNode() {
			this.links = new TrieNode[R];
		}
		
		public boolean containsKey(char ch) {
			return this.links[ch - 97] != null;
		}
		
		public TrieNode get(char ch) {
			return this.links[ch - 97];
		}
		
		public void put(char ch, TrieNode node) {
			this.links[ch - 97] = node;
		}
		
		public void setEnd() {
			this.isEnd = true;
		}
		
		public boolean isEnd() {
			return this.isEnd;
		}
	}
	
	public static class Trie {
		private TrieNode root;
		
		public Trie() {
			this.root = new TrieNode();
		}
		
		public void insert(String word) {
			TrieNode node = this.root;
			
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				
				if (!node.containsKey(c)) {
					node.put(c, new TrieNode());
				}
				
				node = node.get(c);
			}
			
			node.setEnd();
		}
		
		private TrieNode searchPrefix(String word) {
			TrieNode node = this.root;
			
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				
				if (node.containsKey(c)) {
					node = node.get(c);
				} else {
					return null;
				}
			}
			
			return node;
		}
		
		public boolean search(String word) {
			TrieNode node = searchPrefix(word);
			
			return node != null && node.isEnd();
		}
		
		public boolean startsWith(String prefix) {
			return searchPrefix(prefix) != null;
		}
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}
}