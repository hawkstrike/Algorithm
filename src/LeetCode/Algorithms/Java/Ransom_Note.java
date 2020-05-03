package LeetCode.Algorithms.Java;

import java.util.Hashtable;

// https://leetcode.com/problems/ransom-note/
public class Ransom_Note {
	public static void main(String[] args) {
		String ransomNote = "a";
		String magazine = "b";
		
		System.out.println(canConstruct(ransomNote, magazine));
	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] alphabet = new int[26];
		
		for (char c : magazine.toCharArray()) {
			alphabet[c - 'a']++;
		}
		
		for (char c : ransomNote.toCharArray()) {
			if (--alphabet[c - 'a'] < 0) {
				return false;
			}
		}
		
		return true;
	}
}