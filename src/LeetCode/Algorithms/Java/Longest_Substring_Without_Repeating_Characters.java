package LeetCode.Algorithms.Java;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Longest_Substring_Without_Repeating_Characters {
	public static void main(String[] args) {
		String s = "abcabcbb";
		
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int length = s.length();
		int result = 0;
		int[] indexArr = new int[128];
		
		for (int i = 0, j = 0; j < length; j++) {
			i = Math.max(indexArr[s.charAt(j)], i);
			result = Math.max(result, j - i + 1);
			indexArr[s.charAt(j)] = j + 1;
		}
		
		return result;
	}
}