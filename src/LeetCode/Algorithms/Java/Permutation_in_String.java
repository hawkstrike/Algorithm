package LeetCode.Algorithms.Java;

import java.util.Arrays;

// https://leetcode.com/problems/permutation-in-string/
public class Permutation_in_String {
	public static void main(String[] args) {
		String s1 = "ab";
//		String s2 = "eidbaooo";
		String s2 = "eidboaoo";
		
		System.out.println(checkInclusion(s1, s2));
	}
	
	public static boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}
		
		int[] s1Alphabet = new int[26];
		int[] s2Alphabet = new int[26];
		
		for (int i = 0; i < s1.length(); i++) {
			s1Alphabet[s1.charAt(i) - 'a']++;
			s2Alphabet[s2.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < s2.length() - s1.length(); i++) {
			if (Arrays.equals(s1Alphabet, s2Alphabet)) {
				return true;
			}
			
			s2Alphabet[s2.charAt(i + s1.length()) - 'a']++;
			s2Alphabet[s2.charAt(i) - 'a']--;
		}
		
		return Arrays.equals(s1Alphabet, s2Alphabet);
	}
}