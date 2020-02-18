package LeetCode.Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/replace-words/
public class Replace_Words {
	public static void main(String[] args){
		ArrayList<String> dict = new ArrayList<>();
		String sentence = "the cattle was rattled by the battery"; // "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"; // "aadsfasf absbs bbab cadsfafs"; //
		
		/*dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");*/
		/*dict.add("a");
		dict.add("b");
		dict.add("c");*/
		dict.add("cat");
		dict.add("bat");
		dict.add("rat");
		
		System.out.println(replaceWords(dict, sentence));
	}
	
	public static String replaceWords(List<String> dict, String sentence) {
		StringBuilder result = new StringBuilder();
		Set<String> hashSet = new HashSet<>();
		String[] sentenceArr = sentence.split("\\s");
		
		for (String word : dict) {
			hashSet.add(word);
		}
		
		for (String word : sentenceArr) {
			String prefix = "";
			
			for (int i = 1; i <= word.length(); i++) {
				prefix = word.substring(0, i);
				
				if (hashSet.contains(prefix)) {
					break;
				}
			}
			
			if (result.length() > 0) {
				result.append(" ");
			}
			
			result.append(prefix);
		}
		
		return result.toString();
	}
}