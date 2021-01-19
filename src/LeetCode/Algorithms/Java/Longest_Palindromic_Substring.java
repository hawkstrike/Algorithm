package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/longest-palindromic-substring/
public class Longest_Palindromic_Substring {
	public static void main(String[] args) {
		String s = "babad";
		
		System.out.println(longestPalindrome(s));
	}
	
	public static String longestPalindrome(String s) {
		char[] cArr = s.toCharArray();
		int length = s.length();
		boolean[][] dp = new boolean[length][2];
		
		int col = 0;
		int maxLength = Integer.MIN_VALUE;
		int result = 0;
		
		for (int i = 0; i < length; i++) {
			for (int start = 0; start + i < length; start++) {
				int end = start + i;
				
				if (i == 0) {
					dp[start][col] = true;
				} else if (i == 1) {
					dp[start][col] = (cArr[start] == cArr[end]);
				} else {
					dp[start][col] = (cArr[start] == cArr[end] && dp[start + 1][col]);
				}
				
				if (dp[start][col] && i + 1 > maxLength) {
					result = start;
					maxLength = i + 1;
				}
			}
			
			col = 1 - col;
		}
		
		return (maxLength == 0) ? "" : s.substring(result, result + maxLength);
	}
}