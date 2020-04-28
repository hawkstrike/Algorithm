package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/longest-common-subsequence/
public class Longest_Common_Subsequence {
	public static void main(String[] args) {
		String text1 = "abc"; // "abcde";
		String text2 = "def"; // "ace";
		
		System.out.println(longestCommonSubsequence(text1, text2));
	}
	
	public static int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		return dp[dp.length - 1][dp[0].length - 1];
	}
}