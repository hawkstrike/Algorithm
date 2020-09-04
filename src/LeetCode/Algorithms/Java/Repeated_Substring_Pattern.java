package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/repeated-substring-pattern/
public class Repeated_Substring_Pattern {
	public static void main(String[] args) {
		//String s = "abcabcabcabc";
		String s = "ababab";
		
		System.out.println(repeatedSubstringPattern(s));
	}
	
	public static boolean repeatedSubstringPattern(String s) {
		//return s.matches("^([a-z]+)\\1+$");
		int length = s.length();
		
		for (int i = length / 2; i > 0; i--) {
			if (length % i != 0) {
				continue;
			}
			
			HashSet<String> hashSet = new HashSet<>();
			
			for (int j = 0; j < length; j += i) {
				hashSet.add(s.substring(j, j + i));
			}
			
			if (hashSet.size() == 1) {
				return true;
			}
		}
		
		return false;
	}
}