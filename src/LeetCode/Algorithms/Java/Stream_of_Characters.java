package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/stream-of-characters/
public class Stream_of_Characters {
	public static class StreamChecker {
		private static class Trie {
			private Trie[] trieArr = new Trie[26];
			private boolean isEnd = false;
		}
		
		private Trie root;
		private StringBuffer sb;
		
		public StreamChecker(String[] words) {
			this.root = new Trie();
			this.sb = new StringBuffer();
			
			for (String word : words) {
				setWord(word);
			}
		}
		
		public boolean query(char letter) {
			this.sb.append(letter);
			
			Trie curr = this.root;
			
			for (int i = this.sb.length() - 1; i >= 0; i--) {
				int index = this.sb.charAt(i) - 'a';
				
				if (curr.trieArr[index] != null) {
					curr = curr.trieArr[index];
					
					if (curr.isEnd) {
						return true;
					}
				} else {
					return false;
				}
			}
			
			return false;
		}
		
		private void setWord(String word) {
			Trie trie = this.root;
			
			for (int i = word.length() - 1; i >= 0; i--) {
				int index = word.charAt(i) - 'a';
				
				if (trie.trieArr[index] == null) {
					trie.trieArr[index] = new Trie();
				}
				
				trie = trie.trieArr[index];
			}
			
			trie.isEnd = true;
		}
	}
	
	public static void main(String[] args) {
		String[] strArr = {"cd", "f", "kl"};
		StreamChecker streamChecker = new StreamChecker(strArr);
		
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('c'));
		System.out.println(streamChecker.query('d'));
		System.out.println(streamChecker.query('e'));
		System.out.println(streamChecker.query('f'));
		System.out.println(streamChecker.query('g'));
		System.out.println(streamChecker.query('h'));
		System.out.println(streamChecker.query('i'));
		System.out.println(streamChecker.query('j'));
		System.out.println(streamChecker.query('k'));
		System.out.println(streamChecker.query('l'));
	}
}