package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/word-pattern/
public class Word_Pattern {
	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat dog";
		
		System.out.println(wordPattern(pattern, str));
	}
	
	public static boolean wordPattern(String pattern, String str) {
		HashMap hashMap = new HashMap();
		String[] words = str.split(" ");
		
		if (words.length != pattern.length()) {
			return false;
		}
		
		for (Integer i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);
			String w = words[i];
			
			if (!hashMap.containsKey(c)) {
				hashMap.put(c, i);
			}
			
			if (!hashMap.containsKey(w)) {
				hashMap.put(w, i);
			}
			
			if (hashMap.get(c) != hashMap.get(w)) {
				return false;
			}
		}
		
		return true;
	}
}