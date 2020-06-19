package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/longest-duplicate-substring/
public class Longest_Duplicate_Substring {
	static int a = 26;
	static int mod = 1 << 30;
	
	public static void main(String[] args) {
		String S = "banana";
		
		System.out.println(longestDupSubstring(S));
	}
	
	public static String longestDupSubstring(String S) {
		int left = 1;
		int right = S.length() - 1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int startIndex = rabinKarp(S, mid);
			
			if (startIndex == -1) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		int startIndex = rabinKarp(S, right);
		
		return startIndex == -1 ? "" : S.substring(startIndex, startIndex + right);
	}
	
	public static int rabinKarp(String S, int length) {
		long hash = 0;
		long aL = 1;
		
		for (int i = 0; i < length; i++) {
			hash = (hash * a % mod + S.charAt(i)) % mod;
			aL = aL * a % mod;
		}
		
		HashMap<Long, List<Integer>> hashMap = new HashMap<>();
		
		hashMap.put(hash, new ArrayList<>());
		hashMap.get(hash).add(0);
		
		for (int i = 1; i < S.length() - length + 1; i++) {
			hash = ((hash * a % mod - S.charAt(i - 1) * aL % mod + mod) % mod + S.charAt(i + length - 1)) % mod;
			
			if (hashMap.containsKey(hash)) {
				for (int start : hashMap.get(hash)) {
					if (S.substring(start, start + length).equals(S.substring(i, i + length))) {
						return i;
					}
				}
			} else {
				hashMap.put(hash, new ArrayList<>());
			}
			
			hashMap.get(hash).add(i);
		}
		
		return -1;
	}
}