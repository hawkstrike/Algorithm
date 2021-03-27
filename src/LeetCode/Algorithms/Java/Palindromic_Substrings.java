package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/palindromic-substrings/
public class Palindromic_Substrings {
	public static void main(String[] args) {
		//String s = "abc";
		String s = "aaa";
		
		System.out.println(countSubstrings(s));
	}
	
	public static int countSubstrings(String s) {
		int result = 0;
		
		for (int i = 0; i < s.length(); i++) {
			result += recurrentCountSubstrings(s, i, i);
			result += recurrentCountSubstrings(s, i, i + 1);
		}
		
		return result;
	}
	
	public static int recurrentCountSubstrings(String str, int low, int high) {
		int count = 0;
		
		while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
			low--;
			high++;
			count++;
		}
		
		return count;
	}
}