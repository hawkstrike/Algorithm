package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/word-ladder/
public class Word_Ladder {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordArr = {"hot", "dot", "dog", "lot", "log", "cog"};
		List<String> wordList = new LinkedList<>();
		
		wordList.addAll(Arrays.asList(wordArr));
		
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		int level = 0;
		
		queue.offer(beginWord);
		visited.add(beginWord);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				String str = queue.poll();
				
				if (str.equals(endWord)) {
					return level + 1;
				}
				
				char[] wordArr = str.toCharArray();
				
				for (int j = 0; j < wordArr.length; j++) {
					char c = wordArr[j];
					
					for (char ch = 'a'; ch <= 'z'; ch++) {
						wordArr[j] = ch;
						String check = new String(wordArr);
						
						if (!visited.contains(check) && wordSet.contains(check)) {
							queue.offer(check);
							visited.add(check);
						}
					}
					
					wordArr[j] = c;
				}
			}
			
			level++;
		}
		
		return 0;
	}
}