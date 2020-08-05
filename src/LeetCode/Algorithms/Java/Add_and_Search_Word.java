package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/add-and-search-word-data-structure-design/
public class Add_and_Search_Word {
	public static class WordDictionary {
		private HashMap<Integer, List<String>> hashMap;
		
		public WordDictionary() {
			this.hashMap = new HashMap<>();
		}
		
		public void addWord(String word) {
			int length = word.length();
			
			if (!this.hashMap.containsKey(length)) {
				List<String> list = new ArrayList<>();
				
				list.add(word);
				this.hashMap.put(length, list);
			} else {
				this.hashMap.get(length).add(word);
			}
		}
		
		public boolean search(String word) {
			int length = word.length();
			
			if (!this.hashMap.containsKey(length)) {
				return false;
			}
			
			List<String> list = this.hashMap.get(length);
			
			for (String s : list) {
				if (isSame(s, word)) {
					return true;
				}
			}
			
			return false;
		}
		
		private boolean isSame(String s1, String s2) {
			for (int i = 0; i < s1.length(); i++) {
				if (s2.charAt(i) != '.' && s2.charAt(i) != s1.charAt(i)) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/*public static class WordDictionary {
		private class TrieNode {
			private TrieNode[] alphabetArr = new TrieNode[26];
			private boolean isEnd;
		}
		
		private TrieNode root;
		
		public WordDictionary() {
			this.root = new TrieNode();
		}
		
		public void addWord(String word) {
			TrieNode trieNode = root;
			
			for (Character c : word.toCharArray()) {
				int index = c - 'a';
				
				if (trieNode.alphabetArr[index] == null) {
					trieNode.alphabetArr[index] = new TrieNode();
				}
				
				trieNode = trieNode.alphabetArr[index];
			}
			
			trieNode.isEnd = true;
		}
		
		public boolean search(String word) {
			return match(word.toCharArray(), root, 0);
		}
		
		private boolean match(char[] wordArr, TrieNode root, int index) {
			if (root == null) {
				return false;
			}
			
			if (index == wordArr.length) {
				return root.isEnd;
			}
			
			char c = wordArr[index];
			
			if (c == '.') {
				for (int i = 0; i < 26; i++) {
					if (root.alphabetArr[i] != null && match(wordArr, root.alphabetArr[i], index + 1)) {
						return true;
					}
				}
			} else {
				return root.alphabetArr[c - 'a'] != null && match(wordArr, root.alphabetArr[c - 'a'], index + 1);
			}
			
			return false;
		}
	}*/
	
	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad"));
		System.out.println(wordDictionary.search("bad"));
		System.out.println(wordDictionary.search(".ad"));
		System.out.println(wordDictionary.search("b.."));
	}
	
	
}