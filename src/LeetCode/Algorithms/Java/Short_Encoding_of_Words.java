package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.HashSet;

// https://leetcode.com/problems/short-encoding-of-words/
public class Short_Encoding_of_Words {
	public static void main(String[] args) {
		//String[] words = {"time", "me", "bell"};
		//String[] words = {"t"};
		String[] words = {"me", "time"};
		
		System.out.println(minimumLengthEncoding(words));
	}
	
	public static int minimumLengthEncoding(String[] words) {
		HashSet<String> hashSet = new HashSet<>(Arrays.asList(words));
		
		for (String word : words) {
			for (int i = 1; i < word.length(); i++) {
				hashSet.remove(word.substring(i));
			}
		}
		
		int result = 0;
		
		for (String word : hashSet) {
			result += word.length() + 1;
		}
		
		return result;
	}
}