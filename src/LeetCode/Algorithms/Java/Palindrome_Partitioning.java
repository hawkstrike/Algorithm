package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/
public class Palindrome_Partitioning {
	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> result = partition(s);
		
		for (List<String> list : result) {
			for (String str : list) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> partition(String s) {
		int length = s.length();
		boolean[][] dp = new boolean[length][length];
		List<List<String>> result = new LinkedList<>();
		
		recurrentPartition(result, new LinkedList<>(), s, 0, dp);
		
		return result;
	}
	
	public static void recurrentPartition(List<List<String>> result, List<String> list, String s, int start, boolean[][] dp) {
		if (start >= s.length()) {
			result.add(new LinkedList<>(list));
		}
		
		for (int end = start; end < s.length(); end++) {
			if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
				dp[start][end] = true;
				list.add(s.substring(start, end + 1));
				
				recurrentPartition(result, list, s, end + 1, dp);
				
				list.remove(list.size() - 1);
			}
		}
	}
}