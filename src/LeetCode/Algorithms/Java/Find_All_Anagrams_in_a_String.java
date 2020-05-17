package LeetCode.Algorithms.Java;

import java.util.*;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class Find_All_Anagrams_in_a_String {
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		
		List<Integer> result = findAnagrams(s, p);
		
		for (int index : result) {
			System.out.print(index + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int[] sAlphabet = new int[26];
		int[] pAlphabet = new int[26];
		int sLength = s.length();
		int pLength = p.length();
		
		if (sLength == 0 || pLength >= sLength) {
			return result;
		}
		
		for (int i = 0; i < pLength; i++) {
			sAlphabet[s.charAt(i) - 'a']++;
			pAlphabet[p.charAt(i) - 'a']++;
		}
		
		for (int i = pLength; i < sLength; i++) {
			if (Arrays.equals(sAlphabet, pAlphabet)) {
				result.add(i - pLength);
			}
			
			sAlphabet[s.charAt(i - pLength) - 'a']--;
			sAlphabet[s.charAt(i) - 'a']++;
		}
		
		if (Arrays.equals(sAlphabet, pAlphabet)) {
			result.add(sLength - pLength);
		}
		
		return result;
	}
}