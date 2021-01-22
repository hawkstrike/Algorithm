package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/determine-if-two-strings-are-close/
public class Determine_if_Two_Strings_Are_Close {
	public static void main(String[] args) {
		/*String word1 = "abc";
		String word2 = "bca";*/
		/*String word1 = "a";
		String word2 = "aa";*/
		String word1 = "cabbba";
		String word2 = "abbccc";
		/*String word1 = "cabbba";
		String word2 = "aabbss";*/
		/*String word1 = "uau";
		String word2 = "ssx";*/
		
		System.out.println(closeStrings(word1, word2));
	}
	
	public static boolean closeStrings(String word1, String word2) {
		int[] cArr1 = new int[26];
		int[] cArr2 = new int[26];
		char[] word1Arr = word1.toCharArray();
		char[] word2Arr = word2.toCharArray();
		HashSet<Character> cHashSet1 = new HashSet<>();
		HashSet<Character> cHashSet2 = new HashSet<>();
		
		for (char c : word1Arr) {
			cArr1[c - 'a']++;
			cHashSet1.add(c);
		}
		
		for (char c : word2Arr) {
			cArr2[c - 'a']++;
			cHashSet2.add(c);
		}
		
		HashSet<Integer> word1HashSet = new HashSet<>();
		HashSet<Integer> word2HashSet = new HashSet<>();
		
		for (int c : cArr1) {
			word1HashSet.add(c);
		}
		
		for (int c : cArr2) {
			word2HashSet.add(c);
		}
		
		return cHashSet1.equals(cHashSet2) && word1HashSet.equals(word2HashSet);
	}
}