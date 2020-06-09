package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/is-subsequence/
public class Is_Subsequence {
	public static void main(String[] args) {
		/*String s = "abc";
		String t = "ahbgdc";*/
		String s = "axc";
		String t = "ahbgdc";
		
		System.out.println(isSubsequence(s, t));
	}
	
	public static boolean isSubsequence(String s, String t) {
		int i = 0;
		int j = 0;
		
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			
			j++;
		}
		
		return i == s.length();
	}
}