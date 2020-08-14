package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/longest-palindrome/
public class Longest_Palindrome {
	public static void main(String[] args) {
		String s = "abccccdd";
		
		System.out.println(longestPalindrome(s));
	}
	
	public static int longestPalindrome(String s) {
		int[] count = new int[128];
		int result = 0;
		
		for (char c : s.toCharArray()) {
			count[c]++;
		}
		
		for (int n : count) {
			result += n / 2 * 2;
			
			if (result % 2 == 0 && n % 2 == 1) {
				result++;
			}
		}
		
		return result;
	}
}