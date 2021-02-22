package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
public class Longest_Word_in_Dictionary_through_Deleting {
	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> d = new LinkedList<>();
		
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");
		
		System.out.println(findLongestWord(s, d));
	}
	
	public static String findLongestWord(String s, List<String> d) {
		String result = "";
		
		for (String str : d) {
			if (isSubsequence(str, s)) {
				if (str.length() > result.length() || (str.length() == result.length() && str.compareTo(result) < 0)) {
					result = str;
				}
			}
		}
		
		return result;
	}
	
	public static boolean isSubsequence(String x, String y) {
		int index = 0;
		
		for (int i = 0; i < y.length() && index < x.length(); i++) {
			if (x.charAt(index) == y.charAt(i)) {
				index++;
			}
		}
		
		return index == x.length();
	}
}