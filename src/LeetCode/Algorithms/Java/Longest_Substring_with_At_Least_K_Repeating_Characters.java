package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class Longest_Substring_with_At_Least_K_Repeating_Characters {
	public static void main(String[] args) {
		String s = "aaabb";
		int k = 3;
		
		System.out.println(longestSubstring(s, k));
	}
	
	public static int longestSubstring(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		char[] alphabetArr = new char[26];
		boolean flag = true;
		
		for (int i = 0; i < s.length(); i++) {
			alphabetArr[s.charAt(i) - 'a']++;
		}
		
		for (char alphabet : alphabetArr) {
			if (alphabet < k && alphabet > 0) {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			return s.length();
		}
		
		int result = 0;
		int start = 0;
		int curr = 0;
		
		while (curr < s.length()) {
			if (alphabetArr[s.charAt(curr) - 'a'] < k) {
				result = Math.max(result, longestSubstring(s.substring(start, curr), k));
				start = curr + 1;
			}
			
			curr++;
		}
		
		result = Math.max(result, longestSubstring(s.substring(start), k));
		
		return result;
	}
}