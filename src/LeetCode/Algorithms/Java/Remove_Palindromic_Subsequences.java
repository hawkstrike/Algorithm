package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/remove-palindromic-subsequences/
public class Remove_Palindromic_Subsequences {
	public static void main(String[] args) {
		String s = "ababa";
		
		System.out.println(removePalindromeSub(s));
	}
	
	public static int removePalindromeSub(String s) {
		if (s.length() == 0) {
			return 0;
		} else if (recurrentCheckPalindrome(s)) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public static boolean recurrentCheckPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		
		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		
		return true;
	}
}