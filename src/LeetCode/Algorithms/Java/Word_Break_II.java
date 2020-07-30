package LeetCode.Algorithms.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/word-break-ii/
public class Word_Break_II {
	public static void main(String[] args) {
		String s = "catsanddog";
		String[] arr = {"cat", "cats", "and", "sand", "dog"};
		List<String> wordDict = Arrays.asList(arr);
		List<String> result = wordBreak(s, wordDict);
		
		for (String str : result) {
			System.out.println(str);
		}
	}
	
	public static List<String> wordBreak(String s, List<String> wordDict) {
		if (s.length() > 100) {
			return new ArrayList<>();
		}
		
		List<String> result = new ArrayList<>();
		
		recurrentWordBreak(s, wordDict, result, new StringBuffer());
		
		return result;
	}
	
	public static void recurrentWordBreak(String s, List<String> wordDict, List<String> result, StringBuffer sb) {
		if (sb.length() > 0) {
			sb.append(" ");
		}
		
		for (String word : wordDict) {
			if (s.indexOf(word) == 0) {
				StringBuffer tempSb = new StringBuffer(sb);
				
				tempSb.append(word);
				//sb.append(word);
				
				if (s.equals(word)) {
					result.add(tempSb.toString());
					//result.add(sb.toString());
				} else {
					recurrentWordBreak(s.substring(word.length()), wordDict, result, tempSb);
					//recurrentWordBreak(s.substring(word.length()), wordDict, result, sb);
				}
			}
		}
	}
}