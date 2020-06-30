package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-search-ii/
public class Word_Search_II {
	public static class Trie {
		Trie[] next = new Trie[26];
		String word;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'o', 'a', 'a', 'n'},
						{'e', 't', 'a', 'e'},
						{'i', 'h', 'k', 'r'},
						{'i', 'f', 'l', 'v'}};
		String[] words = {"oath", "pea", "eat", "rain"};
		List<String> result = findWords(board, words);
		
		for (String word : result) {
			System.out.println(word);
		}
	}
	
	public static List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		Trie root = buildTrie(words);
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(result, board, root, i, j);
			}
		}
		
		return result;
	}
	
	public static Trie buildTrie(String[] words) {
		Trie root = new Trie();
		
		for (String word : words) {
			Trie t = root;
			
			for (char c : word.toCharArray()) {
				int i = c - 'a';
				
				if (t.next[i] == null) {
					t.next[i] = new Trie();
				}
				
				t = t.next[i];
			}
			
			t.word = word;
		}
		
		return root;
	}
	
	public static void dfs(List<String> result, char[][] board, Trie root, int i, int j) {
		char c = board[i][j];
		
		if (c == '#' || root.next[c - 'a'] == null) {
			return;
		}
		
		root = root.next[c - 'a'];
		
		if (root.word != null) {
			result.add(root.word);
			root.word = null;
		}
		
		board[i][j] = '#';
		
		if (i > 0) {
			dfs(result, board, root,i - 1, j);
		}
		if (j > 0) {
			dfs(result, board, root, i, j - 1);
		}
		if (i < board.length - 1) {
			dfs(result, board, root, i + 1, j);
		}
		if (j < board[0].length - 1) {
			dfs(result, board, root, i, j + 1);
		}
		
		board[i][j] = c;
	}
}