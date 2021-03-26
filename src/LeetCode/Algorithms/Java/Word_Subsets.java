package LeetCode.Algorithms.Java;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/word-subsets/
public class Word_Subsets {
	public static void main(String[] args) {
		String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
		//String[] B = {"e", "o"};
		//String[] B = {"l", "e"};
		//String[] B = {"e", "oo"};
		String[] B = {"lo", "eo"};
		List<String> result = wordSubsets(A, B);
		
		for (String str : result) {
			System.out.println(str);
		}
	}
	
	public static List<String> wordSubsets(String[] A, String[] B) {
		List<String> result = new LinkedList<>();
		int[] arr = new int[26];
		
		for (String word : B) {
			int[] count = countAlphabet(word);
			
			for (int i = 0; i < 26; i++) {
				arr[i] = Math.max(arr[i], count[i]);
			}
		}
		
		search: for (String sentence : A) {
			int[] count = countAlphabet(sentence);
			
			for (int i = 0; i < 26; i++) {
				if (count[i] < arr[i]) {
					continue search;
				}
			}
			
			result.add(sentence);
		}
		
		return result;
	}
	
	public static int[] countAlphabet(String word) {
		int[] count = new int[26];
		
		for (char c : word.toCharArray()) {
			count[c - 'a']++;
		}
		
		return count;
	}
}