package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/word-break/
public class Word_Break {
	public static void main(String[] args) {
		String[] arr = {"leet", "code"};
		String s = "leetcode";
		List<String> wordDict = Arrays.asList(arr);
		
		System.out.println(wordBreak(s, wordDict));
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> hashSet = new HashSet<>(wordDict);
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[s.length()];
		
		q.offer(0);
		
		while (!q.isEmpty()) {
			int start = q.poll();
			
			if (!visited[start]) {
				for (int end = start + 1; end <= s.length(); end++) {
					if (hashSet.contains(s.substring(start, end))) {
						if (end == s.length()) {
							return true;
						}
						
						q.offer(end);
					}
				}
				
				visited[start] = true;
			}
		}
		
		return false;
	}
}