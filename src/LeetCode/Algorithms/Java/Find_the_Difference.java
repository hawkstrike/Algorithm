package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/find-the-difference/
public class Find_the_Difference {
	public static void main(String[] args) {
		String s = "abcd";
		String t = "abcde";
		
		System.out.println(findTheDifference(s, t));
	}
	
	public static char findTheDifference(String s, String t) {
		char c = t.charAt(t.length() - 1);
		
		for (int i = 0; i < s.length(); i++) {
			c ^= s.charAt(i);
			c ^= t.charAt(i);
		}
		
		return c;
		
		/*HashMap<Character, Character> hashMap = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (!hashMap.containsKey(c)) {
				hashMap.put(c, c);
			} else {
				hashMap.remove(c);
			}
		}
		
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			
			if (!hashMap.containsKey(c)) {
				hashMap.put(c, c);
			} else {
				hashMap.remove(c);
			}
		}
		
		return (char) hashMap.values().toArray()[0];*/
	}
}