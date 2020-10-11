package LeetCode.Algorithms.Java;

import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/
public class Remove_Duplicate_Letters {
	public static void main(String[] args) {
		String s = "bcabc";
		
		System.out.println(removeDuplicateLetters(s));
	}
	
	public static String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		int[] alphabetArr = new int[26];
		boolean[] visited = new boolean[26];
		
		for (int i = 0; i < s.length(); i++) {
			alphabetArr[s.charAt(i) - 'a']++;
		}
		
		for(char c : s.toCharArray()) {
			int index = c - 'a';
			
			alphabetArr[index]--;
			
			if (visited[index]) {
				continue;
			}
			
			while (!stack.isEmpty() && stack.peek() > c && alphabetArr[stack.peek() - 'a'] > 0) {
				visited[stack.pop() - 'a'] = false;
			}
			
			stack.push(c);
			visited[index] = true;
		}
		
		StringBuffer sb = new StringBuffer();
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.reverse().toString();
	}
}