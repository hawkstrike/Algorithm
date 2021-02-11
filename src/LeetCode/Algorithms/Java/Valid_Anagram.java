package LeetCode.Algorithms.Java;

import java.util.HashMap;

// https://leetcode.com/problems/valid-anagram/
public class Valid_Anagram {
	public static void main(String[] args) {
		/*String s = "anagram";
		String t = "nagaram";*/
		String s = "rat";
		String t = "car";
		
		System.out.println(isAnagram(s, t));
	}
	
	public static boolean isAnagram(String s, String t) {
		int[] sArr = new int[26];
		int[] tArr = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			sArr[s.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < t.length(); i++) {
			tArr[t.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i] != tArr[i]) {
				return false;
			}
		}
		
		return true;
	}
}