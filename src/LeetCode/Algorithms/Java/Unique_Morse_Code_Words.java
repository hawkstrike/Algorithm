package LeetCode.Algorithms.Java;

import java.util.HashSet;

// https://leetcode.com/problems/unique-morse-code-words/
public class Unique_Morse_Code_Words {
	public static void main(String[] args) {
		String[] words = {"gin", "zen", "gig", "msg"};
		
		System.out.println(uniqueMorseRepresentations(words));
	}
	
	public static int uniqueMorseRepresentations(String[] words) {
		String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.",
				"--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
				"---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
				".--","-..-","-.--","--.."};
		HashSet<String> hashSet = new HashSet<>();
		
		for (String word : words) {
			StringBuffer sb = new StringBuffer();
			
			for (char c : word.toCharArray()) {
				sb.append(morseCode[c - 'a']);
			}
			
			hashSet.add(sb.toString());
		}
		
		return hashSet.size();
	}
}