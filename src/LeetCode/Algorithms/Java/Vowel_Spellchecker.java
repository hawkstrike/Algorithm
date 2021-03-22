package LeetCode.Algorithms.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/vowel-spellchecker/
public class Vowel_Spellchecker {
	public static void main(String[] args) {
		String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
		String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
		String[] result = spellchecker(wordlist, queries);
		
		for (String str : result) {
			System.out.println(str);
		}
	}
	
	public static String[] spellchecker(String[] wordlist, String[] queries) {
		HashSet<String> hashSet = new HashSet<>(Arrays.asList(wordlist));
		HashMap<String, String> capHashMap = new HashMap<>();
		HashMap<String, String> vowelHashMap = new HashMap<>();
		
		for (String word : wordlist) {
			String lower = word.toLowerCase();
			String devowel = lower.replaceAll("[aeiou]", "#");
			
			capHashMap.putIfAbsent(lower, word);
			vowelHashMap.putIfAbsent(devowel, word);
		}
		
		for (int i = 0; i < queries.length; i++) {
			if (hashSet.contains(queries[i])) {
				continue;
			}
			
			String lower = queries[i].toLowerCase();
			String devowel = lower.replaceAll("[aeiou]", "#");
			
			if (capHashMap.containsKey(lower)) {
				queries[i] = capHashMap.get(lower);
			} else if (vowelHashMap.containsKey(devowel)) {
				queries[i] = vowelHashMap.get(devowel);
			} else {
				queries[i] = "";
			}
		}
		
		return queries;
	}
}